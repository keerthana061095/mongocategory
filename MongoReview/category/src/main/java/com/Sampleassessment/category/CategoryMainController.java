package com.Sampleassessment.category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryMainController {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	SequenceGenerate sequencegenerate;

	@PostMapping("/addCategory")
	public Response addMainCategory(@RequestBody CategoryModel category) {
		Response response = new Response();
		
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("category").is(category.getCategory()));
			CategoryModel modelIn = mongoTemplate.findOne(query, CategoryModel.class);

			if (modelIn == null) {
				int categoryid = sequencegenerate.categorySeqId("categoryid");
				category.setCategoryid(categoryid);
				category.setStatus(true);
				if (category.getParentId() == null) {
					category.setIsSub(false);
					category.setHasSub(false);
				} else {
					Query queryforsub = new Query();
					queryforsub.addCriteria(Criteria.where("categoryid").is(category.getParentId()));
					CategoryModel data = mongoTemplate.findOne(queryforsub,CategoryModel.class);
					data.setHasSub(true);
					mongoTemplate.save(data);
					category.setIsSub(true);

				}
				category.setCategory(category.getCategory());
				mongoTemplate.save(category);
				response.setResponsecode(1000);
				response.setResponse("success");
			} else {
				response.setResponse("Data Already exist!!");
			}
		} catch (Exception e) {
			response.setResponsecode(1001);
			response.setResponse("faild to insert data!!");
			e.printStackTrace();
		}

		return response;

	}

	@GetMapping("/getCategoryList/{id}")
	public Response getAllCategoryList(@PathVariable("id") Integer id) {
		Response response = new Response();
		List<CategoryModel> data = new ArrayList<>();
		try {
			if (id != null) {
				Query query = new Query();
				query.addCriteria(Criteria.where("parentId").is(id).and("isSub").is(true));
				data = mongoTemplate.find(query,CategoryModel.class);
				if(data.isEmpty() || data == null)
				{
					response.setResponse("Data Not Found");
					
				}else {
					response.setResponsecode(1000);
					response.setResponse("success");
					response.setData(data);
				}

			}

		} catch (Exception e) {
			response.setResponsecode(1001);
			response.setResponse("faild to fetch data!!");
			e.printStackTrace();
		}
		return response;

	}
	@GetMapping("/getCategoryList")
	public Response getAllCategory() {
		Response response = new Response();
		List<CategoryModel> data = new ArrayList<>();
		List<CategoryModel> data2 = new ArrayList<>();
		try {

				Query query = new Query();
			    query.addCriteria(Criteria.where("isSub").is(false).and("status").is(true));
			    data = mongoTemplate.find(query, CategoryModel.class);
			    if(data.isEmpty() || data == null)
			    {
			    	response.setResponse("No Data Found");
			    }else
			    {
					response.setResponsecode(1000);
					response.setResponse("success");
					response.setData(data);
			    }
			    
		} catch (Exception e) {
			response.setResponsecode(1001);
			response.setResponse("faild to fetch data!!");
			e.printStackTrace();
		}
		return response;

	}

	@PutMapping("/updateCategory")
	public Response update(@RequestBody CategoryModel request) {
		Response response = new Response();
		CategoryModel categorymodel = null;
		List<CategoryModel> model = null;
		try {
			Query query = new Query();
		    query.addCriteria(Criteria.where("categoryid").is(request.getCategoryid()).and("status").is(true));
		    categorymodel = mongoTemplate.findOne(query, CategoryModel.class);
		    if(categorymodel != null)
		    {
		    	categorymodel.setCategory(request.getCategory());
		    	mongoTemplate.save(categorymodel);
				response.setResponsecode(1001);
				response.setResponse("Data Modified");
		    }else
		    {
		    	response.setResponse("Unable to Change");
		    }
     			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
		
	}
	@PutMapping("/updateStatus")
	public Response updatestatus(@RequestBody CategoryModel request) {
		Response response = new Response();
		CategoryModel categorymodel = null;
		List<CategoryModel> model = null;
		try {
			Query query = new Query();
		    query.addCriteria(Criteria.where("categoryid").is(request.getCategoryid()));
		    categorymodel = mongoTemplate.findOne(query, CategoryModel.class);
		    if(categorymodel != null)
		    {
		    	categorymodel.setStatus(request.getStatus());
		    	mongoTemplate.save(categorymodel);
				response.setResponsecode(1001);
				response.setResponse("Status Data Modified");
		    }
     			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
		
	}

}
