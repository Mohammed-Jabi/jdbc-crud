package com.vvit.controller;

import com.vvit.dao.CustomerCrud;
import com.vvit.dto.Customer;

public class TestGetCoustomerById {

	public static void main(String[] args) {
	CustomerCrud cc=new CustomerCrud();
	Customer c=cc.getCustomerById(1);
	if(c!=null) {
		System.out.println("Customer ID:"+c.getId());
		System.out.println("Customer Name:"+c.getName());
		System.out.println("Customer Email:"+c.getEmail());
		System.out.println("Customer Age:"+c.getAge());
		System.out.println("Customer Phone_No:"+c.getPhone());
	}else {
		System.out.println("No customer with gven Id");
	}
	}

}
