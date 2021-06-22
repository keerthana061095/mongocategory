package com.Sampleassessment.category;

import java.util.List;


public class SubCategoryModel {

	private int subid;
	private String name;
	private List<SubCategoryModel> value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<SubCategoryModel> getValue() {
		return value;
	}
	public void setValue(List<SubCategoryModel> value) {
		this.value = value;
	}
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	
	
	
	
	
	
}
