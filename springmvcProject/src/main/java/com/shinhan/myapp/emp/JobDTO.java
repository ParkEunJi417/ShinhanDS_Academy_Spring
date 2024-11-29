package com.shinhan.myapp.emp;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// DTO : Data Transfer Object
// VO : Value Object
@Getter@Setter@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobDTO {
	String job_id;
	String job_title;
	int min_salary;
	int max_salary;	
}
