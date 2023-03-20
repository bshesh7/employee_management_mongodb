package com.example.demo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Document(collection = "Employee")
public class Employee {

	@Id
	public long _id;
	
	public String eFname;
	public String eLname;
	public String dob;
	public String ssn;
	
}
