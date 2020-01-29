package com.xmr.ruigou.service;

import com.github.pagehelper.PageInfo;
import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.pojo.Product;
import com.xmr.ruigou.vo.ProductDetailVo;

/**
 * Created by xmr on 2019/12/6.
 */
public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Long productId, Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Long productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchProduct(String productName, Long productId, int pageNum, int pageSize);

    ServerResponse<ProductDetailVo> getProductDetail(Long productId);

    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Long categoryId, int pageNum, int pageSize, String orderBy);

}
