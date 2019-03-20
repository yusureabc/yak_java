package io.renren.modules.yak.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 网址分类
 *
 * @author Scott Yu
 * @email yusureyes@gmail.com
 * @date 2019-03-20 13:35:19
 */
@Data
@TableName("yak_category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增ID
	 */
	@TableId
	private Integer id;
	/**
	 * 分类名称
	 */
	private String name;
	/**
	 * 分类图标
	 */
	private String icon;
	/**
	 * 排序（0最靠上）
	 */
	private Integer sort;
	/**
	 * 创建时间
	 */
	private Date createdAt;
	/**
	 * 更新时间
	 */
	private Date updatedAt;

}
