package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins ="*")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;

	
	@PostMapping("/api/employees")
	public ResponseEntity<Employee> saveBook(@RequestBody Employee employee) {
		//repository.save(employee);
		return new ResponseEntity<Employee>(repository.save(employee),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/api/employees")
	public List<Employee> getEmployees(){
		return repository.findAll();
	}

	@GetMapping("/api/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable long id){
		return repository.findById(id);
	}
	
	@PostMapping("/api/employees/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable long id) {
		//repository.save(employee);
		repository.deleteById(id);
		return new ResponseEntity<Employee>(repository.save(employee),HttpStatus.CREATED);	
	}
	
	


	@DeleteMapping("/api/employees/{id}")
	public String deleteEmployee(@PathVariable long id) {
		repository.deleteById(id);
		return ("Deleted");
		
		
	}

}
