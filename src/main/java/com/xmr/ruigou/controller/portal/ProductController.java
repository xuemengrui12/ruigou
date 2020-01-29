package com.xmr.ruigou.controller.portal;

import com.github.pagehelper.PageInfo;
import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.service.IProductService;
import com.xmr.ruigou.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品接口，暂未使用
 * Created by xmr on 2019/12/7.
 */
@RestController
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    private IProductService iProductService;



    @RequestMapping("/detail")
    public ServerResponse<ProductDetailVo> detail(Long productId){
        return iProductService.getProductDetail(productId);
    }

    @RequestMapping("/list")
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword",required = false)String keyword,
                                         @RequestParam(value = "categoryId",required = false)Long categoryId,
                                         @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                         @RequestParam(value = "orderBy",defaultValue = "") String orderBy){
        return iProductService.getProductByKeywordCategory(keyword,categoryId,pageNum,pageSize,orderBy);
    }


}
