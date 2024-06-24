package com.springbootproject.OrgenisationSytem.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.springbootproject.OrgenisationSytem.entity.Country;
import com.springbootproject.OrgenisationSytem.entity.Employee;


@Repository
public class MainDao {
	
	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		Session session=null;
		Transaction tx=null;
		String msg = null;
		
		try {		
		 session= factory.openSession();
		tx=session.beginTransaction();		
		session.persist(c);
		tx.commit();
		msg="Country is added...";
		}catch (Exception e) {
						
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();			
		}finally {
			
			if(session!=null) {
				session.close();
			}			
		}
		
		return msg;		
	}

	public String updateCountry(int id, Country c) {
		Session session = null;
		Transaction tx =null;
		String msg = null;
		
		try {
			
			session = factory.openSession();
			tx=session.beginTransaction();
			
			Country country = session.get(Country.class, id);
			
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			
			msg ="Country is updated...";
	 
		    }catch(Exception e) {
		    	
		    	if(tx!=null) {
		    		tx.rollback();
		    	}
			
			e.printStackTrace();
			
		}finally {
			if(session!=null) {
				session.close();
				
				
			}
		}
		
	      return msg;
	}

	public String addEmployee(Employee emp) {
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session =factory.openSession();
			tx =session.beginTransaction();
			
			session.persist(emp);
			tx.commit();
			msg="Record Added Successfully...";
			
			
		}catch(Exception e) {
			
			if(tx!=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
			
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		
		return null;
	}

	public String updateEmployee(Employee emp) {
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			
			session =factory.openSession();
			tx=session.beginTransaction();
			Employee employee =session.get(Employee.class, emp.getId());
			
			employee.setName(emp.getName());
			employee.setCountry(emp.getCountry());
			employee.setCreatedby(emp.getCreatedby());
			employee.setCreateddtm(emp.getCreateddtm());
			employee.setUpdatedby(emp.getUpdatedby());
			employee.setUpdateddtm(emp.getUpdateddtm());
			employee.setDepartment(emp.getDepartment());
			employee.setStatus(emp.getStatus());
			employee.setPhoneno(emp.getPhoneno());
			employee.setEmailid(emp.getEmailid());
			employee.setSalary(emp.getSalary());
			
			session.merge(employee);
			tx.commit();
			msg="Employee Updated Succesfully";
			
			
			
			}catch(Exception e) {
			    if(tx!=null) {
			    tx.rollback();
				}
			    e.printStackTrace();
			
	        }finally {
			
	             if(session!=null) {
	             session.close();
	            }
		
		}
		
		return msg;
	}

	public Employee loginCheck(Employee emp) {
		
		Session session=null;
		Transaction tx=null;
		Employee employee = null;
		
		String hqlQuery="From Employee where emailid =:myemailid and phoneno=:myphone";
		
		try {		
		 session= factory.openSession();
		tx=session.beginTransaction();	
		Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
		
		query.setParameter("myemailid",emp.getEmailid());
		query.setParameter("myphone",emp.getPhoneno());
		
		employee = query.uniqueResult();
		tx.commit();
		
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
				
			}
			e.printStackTrace();
			
		}finally {
			if(session!=null) {
				
			}
			
		}
		
		return employee;
	}


           
}