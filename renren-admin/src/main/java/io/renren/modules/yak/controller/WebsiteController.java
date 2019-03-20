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

import io.renren.modules.yak.entity.WebsiteEntity;
import io.renren.modules.yak.service.WebsiteService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 网址管理
 *
 * @author Scott Yu
 * @email yusureyes@gmail.com
 * @date 2019-03-20 15:22:01
 */
@RestController
@RequestMapping("yak/website")
public class WebsiteController {
    @Autowired
    private WebsiteService websiteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("yak:website:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = websiteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
/*    @RequestMapping("/info/{id}")
    @RequiresPermissions("yak:website:info")
    public R info(@PathVariable("id") Integer id){
        WebsiteEntity website = websiteService.selectById(id);

        return R.ok().put("website", website);
    }*/

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("yak:website:save")
    public R save( @RequestBody WebsiteEntity website ) {
        websiteService.saveWebsite( website );

        return R.ok();
    }

    /**
     * 修改
     */
/*    @RequestMapping("/update")
    @RequiresPermissions("yak:website:update")
    public R update(@RequestBody WebsiteEntity website){
        ValidatorUtils.validateEntity(website);
        websiteService.updateAllColumnById(website);//全部更新
        
        return R.ok();
    }*/

    /**
     * 删除
     */
/*    @RequestMapping("/delete")
    @RequiresPermissions("yak:website:delete")
    public R delete(@RequestBody Integer[] ids){
        websiteService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }*/

}
