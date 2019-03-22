package com.yak.index.service;

import com.yak.index.model.Category;
import java.util.List;

/**
 * 网址分类
 *
 * @author Scott Yu
 * @email yusureyes@gmail.com
 * @date 2019-03-20 13:35:19
 */
public interface CategoryService {

    public List<Category> getCategoryList();

}