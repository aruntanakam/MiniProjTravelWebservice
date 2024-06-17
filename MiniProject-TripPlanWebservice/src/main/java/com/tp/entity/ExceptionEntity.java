package com.tp.entity;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionEntity {
	
	private String error;
	
	private LocalDateTime timestamp;
	
	private String status;

}
