package com.vvit.controller;

import com.vvit.dao.CustomerCrud;
import com.vvit.dto.Customer;

public class TestInsert {

	public static void main(String[] args) {
		Customer c= new Customer();
		c.setId(4);
		c.setName("Rockey");
		c.setEmail("kyachaiyaraytujko@duniya.com");
		c.setAge(24);
		c.setPhone(990335426l);
		
		CustomerCrud crud=new CustomerCrud();
		int a=crud.insertCustomer(c);
		if(a>0) {
			System.out.println("Dtata Inserted Successfully");
		}else {
			System.out.println("Fail to Inserted Data");
		}
	}
}
