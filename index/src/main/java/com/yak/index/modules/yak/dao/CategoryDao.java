package com.yak.index.modules.yak.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.yak.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 网址分类
 * 
 * @author Scott Yu
 * @email yusureyes@gmail.com
 * @date 2019-03-20 13:35:19
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
