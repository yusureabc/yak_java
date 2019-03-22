package io.renren.modules.yak.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.yak.entity.WebsiteEntity;

import java.util.Map;

/**
 * 网址管理
 *
 * @author Scott Yu
 * @email yusureyes@gmail.com
 * @date 2019-03-20 15:22:01
 */
public interface WebsiteService extends IService<WebsiteEntity> {

    PageUtils queryPage( Map< String, Object > params );

    void saveWebsite( WebsiteEntity website );

    void update( WebsiteEntity website );

    void deleteBatch( Long[] websiteIds );
}

