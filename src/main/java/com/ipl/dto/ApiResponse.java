package com.ipl.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
	private String msg;
	private LocalDateTime timestamp;
	
	public ApiResponse(String msg) {
		super();
		this.msg = msg;
		this.timestamp = LocalDateTime.now();
	}
	
	

}
