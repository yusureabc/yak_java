package io.renren.modules.yak.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Date;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.yak.dao.WebsiteDao;
import io.renren.modules.yak.entity.WebsiteEntity;
import io.renren.modules.yak.service.WebsiteService;


@Service("websiteService")
public class WebsiteServiceImpl extends ServiceImpl<WebsiteDao, WebsiteEntity> implements WebsiteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WebsiteEntity> page = this.page(
            new Query<WebsiteEntity>().getPage(params),
            new QueryWrapper<WebsiteEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveWebsite( WebsiteEntity website ) {
        website.setCreatedAt( new Date() );
        website.setUpdatedAt( new Date() );
        this.save( website );
    }

}
