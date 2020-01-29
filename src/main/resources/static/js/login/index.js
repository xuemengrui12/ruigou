layui.use(['form','layer','jquery'], function () {
    var form = layui.form;
    var layer = layui.layer;
    var $ = layui.jquery;
    form.on('submit(login)', function (data) {
        console.log(JSON.stringify(data.field));
        login(JSON.stringify(data.field));
        return false;
    });
    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
});

function login(data) {
    $.ajax({
        url: "/manage/user/login",
        data:data,
        type: 'post',
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        async: false,//同步
        success: function (result) {
            if(result.code == 200){
                layui.layer.msg('登录成功', {icon: 1})
            }else {
                layui.layer.msg('操作失败\r\n'+result.message, {icon: 2});
            }
        }
    });
}