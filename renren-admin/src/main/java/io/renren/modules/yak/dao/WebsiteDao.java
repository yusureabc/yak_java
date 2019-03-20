package io.renren.modules.yak.dao;

import io.renren.modules.yak.entity.WebsiteEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 网址管理
 * 
 * @author Scott Yu
 * @email yusureyes@gmail.com
 * @date 2019-03-20 15:22:01
 */
@Mapper
public interface WebsiteDao extends BaseMapper<WebsiteEntity> {
	
}
