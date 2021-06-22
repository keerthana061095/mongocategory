package com.Sampleassessment.category;

import java.util.List;

public class Response {
	
	private Integer responsecode;
	private String  response;
	private List<CategoryModel> data;
	public Integer getResponsecode() {
		return responsecode;
	}
	public void setResponsecode(Integer responsecode) {
		this.responsecode = responsecode;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public List<CategoryModel> getData() {
		return data;
	}
	public void setData(List<CategoryModel> data) {
		this.data = data;
	}
	
	

}
