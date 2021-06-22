package com.Sampleassessment.category;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="tree")
public class CategoryModel {
	@Id
	private String id;
	private Integer categoryid;
	private Boolean status;
	private String category;
	private Boolean isSub;
	private Boolean hasSub;
	private Integer parentId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Boolean getIsSub() {
		return isSub;
	}
	public void setIsSub(Boolean isSub) {
		this.isSub = isSub;
	}
	public Boolean getHasSub() {
		return hasSub;
	}
	public void setHasSub(Boolean hasSub) {
		this.hasSub = hasSub;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	
	
}
