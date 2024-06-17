package com.tp.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="TRAVEL_CATEGORY")
@Data
public class TravelCategory {

	@Id
	@SequenceGenerator(name = "catgen", sequenceName = "CATEGORY_ID_GENERATOR", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "catgen",strategy = GenerationType.SEQUENCE)
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name="CATEGORY_NAME",length=10)
	private String categoryName;
	
	@Column(name="HOTEL_TYPE",length=30)
	private String hotelType;
	
	@Column(name="TRANSPORT_TYPE",length=30)
	private String transportType;
	
	@Column(name="INCLUSIONS")
	private String inclusions;
	
	@Column(name="EXCLUSIONS")
	private String exclusions;
     
	@CreationTimestamp
	@Column(name="CREATED_DATE",updatable = false)
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name="UPDATED_DATE")
	private LocalDateTime updatedDate;
	

}
