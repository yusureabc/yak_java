package io.renren.modules.yak.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 网址管理
 * 
 * @author Scott Yu
 * @email yusureyes@gmail.com
 * @date 2019-03-20 15:22:01
 */
@Data
@TableName("yak_website")
public class WebsiteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增ID
	 */
	@TableId
	private Integer id;
	/**
	 * 分类ID
	 */
	private Integer categoryId;
	/**
	 * 网站名称
	 */
	private String name;
	/**
	 * 网址
	 */
	private String url;
	/**
	 * 分类图标
	 */
	private String icon;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 遮罩描述
	 */
	private String shade;
	/**
	 * 创建时间
	 */
	private Date createdAt;
	/**
	 * 更新时间
	 */
	private Date updatedAt;

}
