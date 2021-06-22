package com.Sampleassessment.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CategoryController {
/*
	@Autowired
	MongoTemplate mongoTemplate;
	

	@PostMapping("/addCategory")
	public Response addCategory(@RequestBody CategoryModel category)
	{
		Response response = new Response();
		if(category.getCategory().isEmpty() || category.getSubcategory().isEmpty())
		{
			response.setResponse("Category and Subcategory Not be Null..!!");
		}else
		{
			List<SubCategoryModel> sub = null;
			List<String> myList = new ArrayList<String>();
			try {
				sub =  category.getSubcategory();
				for (SubCategoryModel i : sub) {
					myList.add(i.getName().toString());
				}
				Query query = new Query();
				query.addCriteria(Criteria.where("category").is(category.getCategory()).and("subcategory.name").
						in(myList));
				CategoryModel modelIn = mongoTemplate.findOne(query, CategoryModel.class);
							
				if(modelIn == null)
				{
					category.setStatus(true);
					mongoTemplate.save(category);
					response.setResponsecode(1000);
					response.setResponse("success");
				}else
				{
					response.setResponse("Data Already exist!!");
				}
			} catch (Exception e) {
				response.setResponsecode(1001);
				response.setResponse("faild to insert data!!");
				e.printStackTrace();
			}
		}
		
		return response;
		
	}
		
	@GetMapping("/getCategory")
	public List<CategoryModel> getAllCategory()
	{
		Response response = new Response();
		List<CategoryModel> data = new ArrayList<>();
		try {
			data = mongoTemplate.findAll(CategoryModel.class);
			response.setResponsecode(1000);
			response.setResponse("success");
			response.setData(data);
			
		} catch (Exception e) {
			response.setResponsecode(1001);
			response.setResponse("faild to fetch data!!");
			e.printStackTrace();
		}
		return data;
		
	}
	
	@PutMapping("/updateCategory")
	public Response updateCategoryTest(@RequestBody CategoryModel category)
	{
		Response response = new Response();
		if(category.getCategory().isEmpty() || category.getSubcategory().isEmpty())
		{
			response.setResponse("Category and Subcategory Not be Null..!!");
		}else
		{
			CategoryModel categorymodel = null;
			List<SubCategoryModel> sub = null;	
			try {		  
				  sub =  category.getSubcategory();
			      Query query = new Query();
			      query.addCriteria(Criteria.where("category").is(category.getCategory()));
			      categorymodel = mongoTemplate.findOne(query, CategoryModel.class);
			      if(categorymodel.getStatus().TRUE)
			      {
				      categorymodel.setSubcategory(sub);
				      mongoTemplate.save(categorymodel);
					  response.setResponsecode(1000);
					  response.setResponse("successfully updated");
			      }else
			      {
			    	  response.setResponse("Category is DisableMode");
			      }

			} catch (Exception e) {
				response.setResponsecode(1001);
				response.setResponse("faild to update data!!");
				e.printStackTrace();
			}
		}
		
		return response;
		
	}
	
	@PutMapping("/updateCategoryStatus")
	public Response updateCategoryStatus(@RequestBody CategoryModel category)
	{
		Response response = new Response();
		if(category.getCategory().isEmpty() || category.getStatus()== null)
		{
			response.setResponse("Category and Subcategory Not be Null..!!");
		}else
		{
			try {
				
				Query query = new Query();
				query.addCriteria(Criteria.where("category").is(category.getCategory()));
				Update update = new Update().set("status", category.getStatus());
				mongoTemplate.upsert(query, update, CategoryModel.class);
				response.setResponsecode(1000);
				response.setResponse("status updated successfully");
				
			} catch (Exception e) {
				response.setResponsecode(1001);
				response.setResponse("faild to update status!!");
				e.printStackTrace();
			}
		}
	
		return response;
		
	}*/
}
