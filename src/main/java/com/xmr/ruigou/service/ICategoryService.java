package com.xmr.ruigou.service;

import com.xmr.ruigou.common.ServerResponse;
import com.xmr.ruigou.pojo.Category;

import java.util.List;

/**
 * Created by xmr on 2019/12/5.
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Long parentId);
    ServerResponse updateCategoryName(Long categoryId,String categoryName);
    ServerResponse<List<Category>> getChildrenParallelCategory(Long categoryId);
    ServerResponse<List<Long>> selectCategoryAndChildrenById(Long categoryId);

}
