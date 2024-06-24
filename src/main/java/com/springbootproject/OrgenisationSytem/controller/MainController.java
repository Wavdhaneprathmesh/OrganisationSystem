package com.springbootproject.OrgenisationSytem.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.OrgenisationSytem.entity.Country;
import com.springbootproject.OrgenisationSytem.entity.Employee;
import com.springbootproject.OrgenisationSytem.service.MainService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class MainController {
	
	@Autowired
	MainService service;
	
	
	
	 @PostMapping("addcountry")
	 public String addCountry(@RequestBody Country c) {
		// System.out.println(c);
	
	   String msg =  service.addCountry(c);
	   return msg;
	   
	 }

	 
	 @PutMapping("updatecountry/{id}")
	 public String updateCountry(@PathVariable int id,@RequestBody Country c) {
		 
	    String msg =service.updateCountry(id,c);
	    return msg;
 }

	@PostMapping("addemp") 
    public String addEmployee(@RequestBody Employee emp) {
		
		String msg = service.addEmployee(emp);
		 return msg;
		 
		 
		}
	  
	@PutMapping("updateemp")
	public String updateEmployee(@RequestBody Employee emp) {
		
		 String msg =service.updateEmployee(emp);
		 
		return msg;
		
	}
       
	@PostMapping("login")
	public HashMap loginCheck(@RequestBody Employee emp) {
		
		HashMap map =service.loginCheck(emp);
		return map;
		
	}
	
}
