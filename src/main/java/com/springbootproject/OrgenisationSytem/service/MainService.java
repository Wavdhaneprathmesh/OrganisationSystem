package com.springbootproject.OrgenisationSytem.service;

import java.util.HashMap;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.OrgenisationSytem.dao.MainDao;
import com.springbootproject.OrgenisationSytem.entity.Country;
import com.springbootproject.OrgenisationSytem.entity.Employee;

@Service
public class MainService {
	
	  @Autowired    
	  MainDao dao;

	   public String addCountry(Country c) {
		   
		  String msg = dao.addCountry(c);
		  
		     if(Objects.isNull(msg)) {
		    	 
		    	   msg="Country is not addedd...";
		    	 
		    	 
		     }
		  return msg;
		   
	   }

	public String updateCountry(int id, Country c) {
		String msg =dao.updateCountry(id, c);
	  
		if(Objects.isNull(msg)) {
	    	 
	    	   msg="Country is not updated...";
	    	 
	    	   
	     }
		return msg;
	 
	
	}

	public String addEmployee(Employee emp) {
	
		String msg = dao.addEmployee(emp);
		
		    if(Objects.isNull(msg)) {		
			msg="Record is not be addedd...";
	  
		    }
	    return msg;
		     
		
		
	}

	public String updateEmployee(Employee emp) {
		
		String msg = dao.updateEmployee(emp);
		  if(Objects.isNull(msg)) {
			  msg ="Record is not be Updated";
			  
		  }
		
		
		return msg;
	}

	public HashMap loginCheck(Employee emp) {
		Employee e = dao.loginCheck(emp);
		
		HashMap map = new HashMap();
		
		if(Objects.isNull(e)) {
			map.put("msg", "Invalid User..");
			map.put("user", e);
		}else {
			map.put("msg","Valid User");
			map.put("user", e);
		}
         		
		return map;
		
		
		
	}
	
}
