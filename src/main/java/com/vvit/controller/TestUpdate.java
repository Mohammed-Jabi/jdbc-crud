package com.vvit.controller;

import com.vvit.dao.CustomerCrud;
import com.vvit.dto.Customer;

public class TestUpdate {

	public static void main(String[] args) {
		Customer c= new Customer();
		c.setName("Welcome");
		c.setEmail("contoleo@uday.com");
		c.setAge(25);
		c.setPhone(990335426l);
		
		CustomerCrud crud = new CustomerCrud();
		int a=crud.updateCustomerById(4,c);
		if(a>0) {
			System.out.println("Data Updated Successfully");
		}
		else {
			System.out.println("No such Customer");
		}

	

	}

}
