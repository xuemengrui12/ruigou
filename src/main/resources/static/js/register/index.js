layui.use(['form','layer','jquery'], function () {
    var form = layui.form;
    var layer = layui.layer;
    var $ = layui.jquery;
    form.on('submit(register)', function (data) {
        console.log(JSON.stringify(data.field));
        register(JSON.stringify(data.field));
        return false;
    });

});

function register(data) {
    $.ajax({
        url: "/manage/user/register",
        data:data,
        type: 'post',
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        async: false,//同步
        success: function (result) {
            if(result.code == 200){
                layui.layer.msg('注册成功', {icon: 1})
            }else {
                layui.layer.msg('操作失败\r\n'+result.message, {icon: 2});
            }
        }
    });
}

function checkpwd() {
    var pwd1 = $("#password").val();
    var pwd2 = $("#passwordBAK").val();
    if (pwd1 == pwd2) {
        layui.layer.msg('两次输入密码一致',{icon: 1});
        $("#registerBtn").removeClass("layui-btn layui-btn-disabled").addClass("layui-btn layui-btn-normal").attr("disabled",false);
    } else {
        layui.layer.msg('两次输入密码不一致，请重新输入',{icon: 2});
        $("#registerBtn").removeClass("layui-btn layui-btn-normal").addClass("layui-btn layui-btn-disabled").attr("disabled",true);
    }
}