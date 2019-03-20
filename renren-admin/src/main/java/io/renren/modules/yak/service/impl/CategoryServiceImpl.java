package io.renren.modules.yak.service.impl;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.yak.dao.CategoryDao;
import io.renren.modules.yak.entity.CategoryEntity;
import io.renren.modules.yak.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
            new Query<CategoryEntity>().getPage(params),
            new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveCategory( CategoryEntity category ) {
        category.setCreatedAt( new Date() );
        category.setUpdatedAt( new Date() );
        this.save( category );
    }

    @Override
    public void update( CategoryEntity category ) {
        category.setUpdatedAt( new Date() );
        this.updateById( category );
    }

    @Override
    public void deleteBatch( Long[] categoryIds ) {
        this.removeByIds( Arrays.asList( categoryIds ) );
    }

}
