package com.khadri.mart.fruits.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.khadri.mart.fruits.form.FruitsForm;

public class FruitsDao {

	private Connection con;
	private String Url;
	private String User;
	private String Password;

	public FruitsDao(ServletContext context) {
		this.Url = context.getInitParameter("Url");
		this.User = context.getInitParameter("User");
		this.Password = context.getInitParameter("Password");
	}

	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(Url, User, Password);
	}
	public int insertFruits(FruitsForm form) {
		System.out.println("FruitsDao insertFruits(-)");
		int result = 0;
		try {
			con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into fruits values(?,?,?)");
			pstmt.setString(1, form.getItemName());
			pstmt.setInt(2, form.getItemQty());
			pstmt.setDouble(3, form.getItemPrice());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return result;

	}
	
	 public int updateFruitsItem(String name, int qty, double price) {
	        int rowsUpdated = 0;
	        try {
	        	con = getConnection();
	        PreparedStatement preparedStatement = con.prepareStatement("UPDATE Fruits SET qty = ?, price = ? WHERE name = ?");
	            preparedStatement.setInt(1, qty);
	            preparedStatement.setDouble(2, price);
	            preparedStatement.setString(3, name);

	            rowsUpdated = preparedStatement.executeUpdate();
	        } catch (Exception e) {
				e.printStackTrace();
			}
			return rowsUpdated;
	    }
	
	public List<FruitsForm> selectFruits(String Item_name) {
		System.out.println("FruitsDao selectFruits(-)");
		List<FruitsForm> listOfData = new ArrayList<>();
		try {
			con = getConnection();

			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from Fruits where name='" + Item_name+"'");

			while (resultSet.next()) {
				FruitsForm form = new FruitsForm(resultSet.getString(1), resultSet.getInt(2), resultSet.getDouble(3));
				listOfData.add(form);
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return listOfData;

	}
	public List<FruitsForm> selectAllFruits() {
		System.out.println("FruitsDao selectAllFruits(-)");
		List<FruitsForm> listOfClothes = new ArrayList<>();
		try {
			con = getConnection();

			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from fruits");

			while (resultSet.next()) {
				FruitsForm form = new FruitsForm(resultSet.getString(1), resultSet.getInt(2), resultSet.getDouble(3));
				listOfClothes.add(form);
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return listOfClothes;

	}
		  
	}


