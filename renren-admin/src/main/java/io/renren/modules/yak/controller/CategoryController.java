package io.renren.modules.yak.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.yak.entity.CategoryEntity;
import io.renren.modules.yak.service.CategoryService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 网址分类
 *
 * @author Scott Yu
 * @email yusureyes@gmail.com
 * @date 2019-03-20 13:35:19
 */
@RestController
@RequestMapping("yak/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("yak:category:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
/*    @RequestMapping("/info/{id}")
    @RequiresPermissions("yak:category:info")
    public R info(@PathVariable("id") Integer id) {
        CategoryEntity category = categoryService.selectById(id);

        return R.ok().put("category", category);
    }*/

    /**
     * 保存
     */
/*    @RequestMapping("/save")
    @RequiresPermissions("yak:category:save")
    public R save(@RequestBody CategoryEntity category) {
        categoryService.insert(category);

        return R.ok();
    }*/

    /**
     * 修改
     */
/*    @RequestMapping("/update")
    @RequiresPermissions("yak:category:update")
    public R update(@RequestBody CategoryEntity category) {
        ValidatorUtils.validateEntity(category);
        categoryService.updateAllColumnById(category);//全部更新
        
        return R.ok();
    }*/

    /**
     * 删除
     */
/*    @RequestMapping("/delete")
    @RequiresPermissions("yak:category:delete")
    public R delete(@RequestBody Integer[] ids) {
        categoryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }*/

}
