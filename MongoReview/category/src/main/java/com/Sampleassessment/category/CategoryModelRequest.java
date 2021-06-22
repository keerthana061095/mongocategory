package com.Sampleassessment.category;

import java.util.List;

import org.springframework.data.annotation.Id;

public class CategoryModelRequest {

	@Id
	private String id;
	private int categoryid;
	private int subcategoryid;
	private Boolean status;
	private String category;
	private List<SubCategoryModel> subcategory;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public int getSubcategoryid() {
		return subcategoryid;
	}
	public void setSubcategoryid(int subcategoryid) {
		this.subcategoryid = subcategoryid;
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
	public List<SubCategoryModel> getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(List<SubCategoryModel> subcategory) {
		this.subcategory = subcategory;
	}
	
	
}
