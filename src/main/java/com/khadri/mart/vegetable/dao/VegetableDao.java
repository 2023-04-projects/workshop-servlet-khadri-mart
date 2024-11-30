package com.khadri.mart.vegetable.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.khadri.mart.vegetable.form.VegetableForm;

public class VegetableDao {

	private Connection con;
	private String Url;
	private String User;
	private String Password;

	public VegetableDao(ServletContext context) {
		this.Url = context.getInitParameter("Url");
		this.User = context.getInitParameter("User");
		this.Password = context.getInitParameter("Password");
	}

	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(Url, User, Password);
	}

	public int insertVegetable(VegetableForm form) {
		System.out.println("VegetableDao insertVegetable(-)");
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/2024_batch", "root", "Salman@23");

			PreparedStatement pstmt = con.prepareStatement("insert into Vegetable values(?,?,?)");
			pstmt.setString(1, form.getVegName());
			pstmt.setInt(2, form.getVegQty());
			pstmt.setDouble(3, form.getVegPrice());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return result;
	}

	public List<VegetableForm> selectVegetables(String vName) {
		System.out.println("VegetableDao selectVegetable(-)");
		List<VegetableForm> listOfData = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "Salman@23");

			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from vegetable where VEG_NAME='" + vName + "'");

			while (resultSet.next()) {
				VegetableForm form = new VegetableForm(resultSet.getString(1), resultSet.getInt(2),
						resultSet.getDouble(3));
				listOfData.add(form);
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return listOfData;

	}

	public List<VegetableForm> selectAllVegetables() throws SQLException {
		System.out.println("VegetableDao selectAllVegetable(-)");

		List<VegetableForm> vegetableList = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/2024_batch", "root", "Salman@23");
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM vegetable");

			while (resultSet.next()) {
				// Create a new VegetableForm object and populate it
				VegetableForm vegetable = new VegetableForm();
				vegetable.setVegName(resultSet.getString(1));
				vegetable.setVegQty(resultSet.getInt(2));
				vegetable.setVegPrice(resultSet.getDouble(3));

				// Add the vegetable to the list
				vegetableList.add(vegetable);
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return vegetableList;

	}

	public int updateVegetablesItem(String name, int qty, double price) {
		int rowsUpdated = 0;
		try {
			con = getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("UPDATE vegetable SET qty = ?, price = ? WHERE VEG_NAME = ?");
			preparedStatement.setInt(1, qty);
			preparedStatement.setDouble(2, price);
			preparedStatement.setString(3, name);

			rowsUpdated = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}

}
