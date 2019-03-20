package io.renren.modules.yak.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.yak.entity.CategoryEntity;

import java.util.Map;

/**
 * 网址分类
 *
 * @author Scott Yu
 * @email yusureyes@gmail.com
 * @date 2019-03-20 13:35:19
 */
public interface CategoryService extends IService<CategoryEntity> {

	PageUtils queryPage(Map<String, Object> params);
}

