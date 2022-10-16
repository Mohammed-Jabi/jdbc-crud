package com.vvit.controller;

import java.util.ArrayList;

import com.vvit.dao.CustomerCrud;
import com.vvit.dto.Customer;

public class TestGetAllCustomer {

	public static void main(String[] args) {
		CustomerCrud crud=new CustomerCrud();
		ArrayList<Customer> customers= crud.getAllCustomer();
		if(customers.size()>0) {
			for(Customer c: customers) {
				System.out.println("Customer ID:"+c.getId());
				System.out.println("Customer Name:"+c.getName());
				System.out.println("Customer Email:"+c.getEmail());
				System.out.println("Customer Age:"+c.getAge());
				System.out.println("Customer Phone_No:"+c.getPhone());
				System.out.println("********************************");
			}
		}else {
			System.out.println("No Customer in Table");
		}
		
	}

}
