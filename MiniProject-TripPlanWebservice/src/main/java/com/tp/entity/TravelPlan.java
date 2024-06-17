package com.tp.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TRAVEL_PLAN")
@Data
public class TravelPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String planId;

	private String Destination;
	
	private String planType;

	private String planDescription;

	private Integer planCategoryId;

	private Double minimumBudget;

	@CreationTimestamp
	@Column(name = "CREATED_DATE", updatable = false)
	private LocalDateTime createdDate;

	@UpdateTimestamp
	@Column(name = "UPDATED_DATE")
	private LocalDateTime updatedDate;

	private String activeSw;

}
