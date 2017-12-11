package org.tensoft.gaoxiao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>
 * 资源表
 * </p>
 *
 * @author xj
 * @since 2016-12-20
 */
public class TbResource implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 411403408979019743L;
	/**
	 * 资源id
	 */
	private Integer id;
	/**
	 * 资源父id
	 */
	private Integer parentId;
	/**
	 * 资源名称
	 */
	private String name;
	/**
	 * 资源唯一标识
	 */
	private String sourceKey;
	/**
	 * 资源类型,0:目录;1:菜单;2:按钮
	 */
	private Integer type;
	/**
	 * 资源url
	 */
	private String sourceUrl;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 是否隐藏
	 */
	private Integer isHide;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	private boolean selected;
	
	private String parentName;
	
	private List<TbResource> children = new ArrayList<>();
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getParentId() {
		return parentId;
	}


	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSourceKey() {
		return sourceKey;
	}


	public void setSourceKey(String sourceKey) {
		this.sourceKey = sourceKey;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public String getSourceUrl() {
		return sourceUrl;
	}


	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public Integer getIsHide() {
		return isHide;
	}


	public void setIsHide(Integer isHide) {
		this.isHide = isHide;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<TbResource> getChildren() {
		return children;
	}

	public void setChildren(List<TbResource> children) {
		this.children = children;
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getParentName() {
		return parentName;
	}
	
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


}
