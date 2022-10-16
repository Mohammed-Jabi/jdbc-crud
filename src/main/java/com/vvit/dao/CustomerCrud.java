package com.vvit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vvit.dto.Customer;

public class CustomerCrud {

	static String url = "jdbc:mysql://localhost:3306/jdbc_simple1";
	static String user = "root";
	static String password = "jabi@2001";
	static Connection con;

	public int insertCustomer(Customer c) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?,?)");
				ps.setInt(1, c.getId());
				ps.setString(2, c.getName());
				ps.setString(3, c.getEmail());
				ps.setInt(4, c.getAge());
				ps.setLong(5, c.getPhone());
				return ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public Customer getCustomerById(int id) {
		Customer c = new Customer();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement("select * from customer where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setAge(rs.getInt(4));
				c.setPhone(rs.getLong(5));
				return c;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public ArrayList<Customer> getAllCustomer() {
		ArrayList<Customer> customers = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement("select * from customer");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setAge(rs.getInt(4));
				c.setPhone(rs.getLong(5));
				customers.add(c);

			}
			return customers;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;

	}

	public int deleteCustomerById(int id) {
		CustomerCrud crud = new CustomerCrud();
		Customer c = crud.getCustomerById(id);
		if (c != null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = con.prepareStatement("delete from customer where id=?");
				ps.setInt(1, id);
				return ps.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} else {
			return 0;
		}
		return 0;
	}
	public int updateCustomerById(int id, Customer c) {
		CustomerCrud crud = new CustomerCrud();
		Customer c1 = crud.getCustomerById(id);
		if (c1 != null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = con.prepareStatement("update customer set name=?,email=?,age=?,phone=? where id=?");
				ps.setString(1, c.getName());
				ps.setString(2, c.getEmail());
				ps.setInt(3, c.getAge());
				ps.setLong(4, c.getPhone());
				ps.setInt(5, id);
				return ps.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} else {
			return 0;
		}
		return 0;
	}

}
