package com.khadri.mart.grocessary.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.khadri.mart.grocessary.form.GorsaryForm;

public class GrossaryDao {

	public int insertGroossary(GorsaryForm form) {
		System.out.println("GrossaryDao insertGroossary(-)");
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

			PreparedStatement pstmt = con.prepareStatement("insert into grosary values(?,?,?)");
			pstmt.setString(1, form.getGrosaryName());
			pstmt.setInt(2, form.getGrosaryQty());
			pstmt.setDouble(3, form.getGrosaryPrice());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return result;

	}

	public List<GorsaryForm> selectGroossary(String gName) {
		System.out.println("GrossaryDao selectGroossary(-)");
		List<GorsaryForm> listOfData = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from grosary where g_name='" + gName+"'");

			while (resultSet.next()) {
				GorsaryForm form = new GorsaryForm(resultSet.getString(1), resultSet.getInt(2), resultSet.getDouble(3));
				listOfData.add(form);
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return listOfData;

	}
}
