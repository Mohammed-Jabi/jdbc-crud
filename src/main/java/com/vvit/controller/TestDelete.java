package com.vvit.controller;

import com.vvit.dao.CustomerCrud;

public class TestDelete {

	public static void main(String[] args) {
		CustomerCrud crud = new CustomerCrud();
		int a=crud.deleteCustomerById(4);
		if(a>0) {
			System.out.println("Data Delete Successfully");
		}
		else {
			System.out.println("No such Customer");
		}

	}

}
