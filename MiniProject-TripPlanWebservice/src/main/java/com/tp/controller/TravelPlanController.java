package com.tp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.entity.TravelCategory;
import com.tp.entity.TravelPlan;
import com.tp.service.ITravelPlanService;

@RestController
@RequestMapping("/api/travel")
public class TravelPlanController {
	
	@Autowired
	private ITravelPlanService planService;
	
	@PostMapping("/addPlan")
	public ResponseEntity<String> addTravelPlan(@RequestBody TravelPlan plan)
	{
         return new ResponseEntity<String>(planService.addTravelPlan(plan),HttpStatus.CREATED);
	}
	
	@PostMapping("/addCategory")
	public ResponseEntity<String> addTravelCategory(@RequestBody TravelCategory category)
	{
		return new ResponseEntity<String>(planService.addCategory(category),HttpStatus.CREATED);
	}
	
	@GetMapping("/categories")
	public ResponseEntity<List<Map<String,Object>>> getCategories()
	{
		return new ResponseEntity<List<Map<String,Object>>>(planService.getCategories(),HttpStatus.OK);
	}
	
	@GetMapping("/plan/{id}")
	public ResponseEntity<TravelPlan> getPlan(@PathVariable String id)
	{
		return new ResponseEntity<TravelPlan>(planService.getTravelPlan(id),HttpStatus.OK);
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<TravelCategory> getCategory(@PathVariable Integer id)
	{
		return new ResponseEntity<TravelCategory>(planService.getTravelCategory(id),HttpStatus.OK);
	}
	
	@PutMapping("/updatePlan")
	public ResponseEntity<String> updatePlan(@RequestBody TravelPlan plan)
	{
		return new ResponseEntity<String>(planService.updateTravelPlan(plan),HttpStatus.OK);
	}
	
	@PutMapping("/updateCategory")
	public ResponseEntity<String> updateCategory(@RequestBody TravelCategory category)
	{
		return new ResponseEntity<String>(planService.updateCategory(category),HttpStatus.OK);
	}
	
	@GetMapping("/allPlans")
	public ResponseEntity<List<TravelPlan>> getAllPlans()
	{
		return new ResponseEntity<List<TravelPlan>>(planService.getAllTravelPlans(),HttpStatus.OK);
	}
	
	@GetMapping("/allCategories")
	public ResponseEntity<List<TravelCategory>> getAllCategories()
	{
		return new ResponseEntity<List<TravelCategory>>(planService.getAllcategories(),HttpStatus.OK);
	}
	
	@GetMapping("/planbyDest/{destination}")
	public ResponseEntity<List<TravelPlan>> searchPlanByDestination(@PathVariable String destination)
	{
		return new ResponseEntity<List<TravelPlan>>(planService.getTravelPlanByDestination(destination),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deletePlan/{id}")
	public ResponseEntity<String> deletePlan(@PathVariable String id)
	{
		return new ResponseEntity<String>(planService.deleteTravelPlan(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer id)
	{
		return new ResponseEntity<String>(planService.deleteTravelCategory(id),HttpStatus.OK);
	}
	
	@PutMapping("/updateStatus/{id}/{status}")
	public ResponseEntity<String> changeStatus(String id,String status)
	{
		return new ResponseEntity<String>(planService.changeTravelPlanStatus(id, status),HttpStatus.OK);
	}

}
