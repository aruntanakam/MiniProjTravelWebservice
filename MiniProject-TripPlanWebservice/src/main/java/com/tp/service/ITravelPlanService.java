package com.tp.service;

import java.util.List;
import java.util.Map;

import com.tp.entity.TravelCategory;
import com.tp.entity.TravelPlan;

public interface ITravelPlanService {

    String addTravelPlan(TravelPlan plan);//add new travel plan
   
    String addCategory(TravelCategory category);//add travel category
    
    List<Map<String, Object>> getCategories();//get categories Info
    
    TravelPlan getTravelPlan(String id);//get travel plan by id
    
    TravelCategory getTravelCategory(Integer id);//get category details by id
    
    String updateTravelPlan(TravelPlan plan);//update travel plan
    
    String updateCategory(TravelCategory category);//update travel category
    
    List<TravelPlan> getAllTravelPlans();//get all travel plans
    
    List<TravelCategory> getAllcategories();//get all categories
    
    List<TravelPlan> getTravelPlanByDestination(String destination);
    
    String deleteTravelPlan(String id);
    
    String deleteTravelCategory(Integer id);
    
    String changeTravelPlanStatus(String id,String status);
    
    

}
