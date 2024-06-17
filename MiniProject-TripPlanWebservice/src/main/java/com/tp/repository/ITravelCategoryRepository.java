package com.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.TravelCategory;

public interface ITravelCategoryRepository extends JpaRepository<TravelCategory,Integer> {

}
