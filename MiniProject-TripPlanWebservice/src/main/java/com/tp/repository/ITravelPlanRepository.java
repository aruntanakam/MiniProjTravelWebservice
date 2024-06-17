package com.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.TravelPlan;

public interface ITravelPlanRepository extends JpaRepository<TravelPlan,String> {

}
