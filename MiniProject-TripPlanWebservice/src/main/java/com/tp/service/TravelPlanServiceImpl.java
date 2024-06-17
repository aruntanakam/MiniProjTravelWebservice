package com.tp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tp.config.AppConfigProperties;
import com.tp.entity.TravelCategory;
import com.tp.entity.TravelPlan;
import com.tp.repository.ITravelCategoryRepository;
import com.tp.repository.ITravelPlanRepository;
import static com.tp.constants.TravelConstants.*;

@Service
public class TravelPlanServiceImpl implements ITravelPlanService {

	@Autowired
	private ITravelPlanRepository travelRepo;

	@Autowired
	private ITravelCategoryRepository categoryRepo;
	
	private Map<String,String> plan_messages;
	
	private Map<String,String> category_messages;
	
	TravelPlanServiceImpl(AppConfigProperties props)
	{
		this.plan_messages=props.getReturn_messages().get(TRAVEL_PLAN);
		this.category_messages=props.getReturn_messages().get(TRAVEL_CATEGORY);
	}

	@Override
	public String addTravelPlan(TravelPlan plan) {

		TravelPlan tp = travelRepo.save(plan);
		
        if(tp.getPlanId()!=null)
        {
        	return plan_messages.get(SAVE_SUCCCESS)+SPACE+tp.getPlanId();
        }
        
        else
        {
        	return plan_messages.get(SAVE_ERROR);
        }
		
	}

	@Override
	public String addCategory(TravelCategory category) {

		category = categoryRepo.save(category);

		  if(category.getCategoryId()!=null)
	        {
	        	return category_messages.get(SAVE_SUCCCESS)+SPACE+category.getCategoryId();
	        }
	        
	        else
	        {
	        	return category_messages.get(SAVE_ERROR);
	        }
	}

	@Override
	public List<Map<String, Object>> getCategories() {
		
		List<TravelCategory> categories = categoryRepo.findAll();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list=categories.stream().map((category) -> {
			Map<String, Object> map = new LinkedHashMap<>();
			map.put(CATEGORY_NAME, category.getCategoryName());
			map.put(CATEGORY_ID, category.getCategoryId());
			return map;
		}).collect(Collectors.toList());

		return list;
	}

	@Override
	public TravelPlan getTravelPlan(String id) {
		
		return travelRepo.findById(id).orElseThrow(()->new IllegalArgumentException(plan_messages.get(FETCH_ERROR)+SPACE+id));
	}

	@Override
	public TravelCategory getTravelCategory(Integer id) {
		
		return categoryRepo.findById(id).orElseThrow(()->new IllegalArgumentException(category_messages.get(FETCH_ERROR)+SPACE+id));
	}

	@Override
	public String updateTravelPlan(TravelPlan plan) {
		
		Optional<TravelPlan> opt=travelRepo.findById(plan.getPlanId());
		if(opt.isPresent())
		{
			plan=travelRepo.save(plan);
			return plan_messages.get(UPDATE_SUCCESS);
		}
		return plan_messages.get(UPDATE_ERROR)+SPACE+plan.getPlanId();
	}

	@Override
	public String updateCategory(TravelCategory category) {
		Optional<TravelCategory> opt=categoryRepo.findById(category.getCategoryId());
		if(opt.isPresent())
		{
			category=categoryRepo.save(category);
			return  category_messages.get(UPDATE_SUCCESS);
		}
		return  category_messages.get(UPDATE_ERROR)+SPACE+category.getCategoryId();
	}

	@Override
	public List<TravelPlan> getAllTravelPlans() {
		
		return travelRepo.findAll();
	}

	@Override
	public List<TravelCategory> getAllcategories() {
				return categoryRepo.findAll();
	}

	@Override
	public List<TravelPlan> getTravelPlanByDestination(String destination) {
		
		List<TravelPlan> plans=travelRepo.findAll();
		
		plans=plans.stream().filter(plan->plan.getDestination().equalsIgnoreCase(destination)).collect(Collectors.toList());
		
		if(CollectionUtils.isEmpty(plans))
		{
			throw new RuntimeException(plan_messages.get(FETCH_DEST_ERROR)+SPACE+destination);
		} 
		
		return plans;
	}

	@Override
	public String deleteTravelPlan(String id) {
		
		Optional<TravelPlan> opt=travelRepo.findById(id);
		if(opt.isPresent())
		{
			travelRepo.deleteById(id);
			return plan_messages.get(DELETE_SUCCESS);
		}
		return plan_messages.get(DELETE_ERROR)+SPACE+id;
	}

	@Override
	public String deleteTravelCategory(Integer id) {
		Optional<TravelCategory> opt=categoryRepo.findById(id);
		if(opt.isPresent())
		{
			categoryRepo.deleteById(id);
			return  category_messages.get(DELETE_SUCCESS);
		}
		return category_messages.get(DELETE_ERROR)+SPACE+id;
	}

	@Override
	public String changeTravelPlanStatus(String id, String status) {
		Optional<TravelPlan> opt=travelRepo.findById(id);
		if(opt.isPresent())
		{
		   TravelPlan plan=opt.get();
		   plan.setActiveSw(status);
		   travelRepo.save(plan);
		   return plan_messages.get(UPDATE_SUCCESS);
		}
		return plan_messages.get(UPDATE_ERROR)+SPACE+id;
	}

}
