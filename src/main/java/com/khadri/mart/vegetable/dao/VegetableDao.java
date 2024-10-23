package com.khadri.mart.vegetable.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.khadri.mart.vegetable.form.VegetableForm;

public class VegetableDao {

	public int insertVegetable(VegetableForm form) {
		System.out.println("VegetableDao insertVegetable(-)");
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/2024_batch", "root", "Salman@23");

			PreparedStatement pstmt = con.prepareStatement("insert into Vegetable values(?,?,?)");
			pstmt.setString(1, form.getVegetableName());
			pstmt.setInt(2, form.getVegetableQty());
			pstmt.setDouble(3, form.getVegetablePrice());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return result;
	}

	public List<VegetableDao> getAllVegetable(List<VegetableDao> vegetableList) {
		
		
		

		return null;
	}
}