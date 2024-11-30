package com.khadri.mart.grosary.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.khadri.mart.grosary.form.GrosaryForm;

public class GrosaryDao {
	private Connection con;
	private String Url;
	private String User;
	private String Password;

	public GrosaryDao(ServletContext context) {
		this.Url = context.getInitParameter("Url");
		this.User = context.getInitParameter("User");
		this.Password = context.getInitParameter("Password");
	}

	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(Url, User, Password);
	}

	public int insertGrosary(GrosaryForm form) {
		System.out.println("GrosaryDao insertGrosary(-)");
		int result = 0;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();

			pstmt = con.prepareStatement("insert into grosary values(?,?,?)");
			pstmt.setString(1, form.getGrosaryName());
			pstmt.setInt(2, form.getGrosaryQty());
			pstmt.setDouble(3, form.getGrosaryPrice());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		} finally {
			System.out.println();
			try {
				pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	public List<GrosaryForm> selectGrosary(String Name) {
		System.out.println("GrosaryDao selectGrosary(-)");
		List<GrosaryForm> listOfData = new ArrayList<>();
		Statement stmt = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from grosary where name='" + Name + "'");

			while (resultSet.next()) {
				GrosaryForm form = new GrosaryForm(resultSet.getString(1), resultSet.getInt(2), resultSet.getDouble(3));
				listOfData.add(form);
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		} finally {
			System.out.println();
			try {
				stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return listOfData;

	}

	public int updateGrosary(GrosaryForm form) {
		System.out.println("GrosaryDao updateGrosary(-)");
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = getConnection();
			pstmt = con.prepareStatement("UPDATE grosary SET qty=?, price=? WHERE name=?");

			pstmt.setString(1, form.getGrosaryName());
			pstmt.setInt(2, form.getGrosaryQty());

			pstmt.setDouble(3, form.getGrosaryPrice());

			result = pstmt.executeUpdate();
			System.out.println(result + " record modified successfully!");

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println();
			try {
				pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	public List<GrosaryForm> selectAllGrosary() {
		System.out.println("GrosaryDao selectAllGrosary(-)");
		List<GrosaryForm> listOfGrossary = new ArrayList<>();
		Statement stmt = null;
		try {
			con = getConnection();

			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from grosary");

			while (resultSet.next()) {
				GrosaryForm form = new GrosaryForm(resultSet.getString(1), resultSet.getInt(2), resultSet.getDouble(3));
				listOfGrossary.add(form);
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		} finally {
			System.out.println();
			try {
				stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return listOfGrossary;

	}

	public int deleteGrosary(String name) {
		System.out.println("GrosaryDao deleteGrosary(-)");
		int result = 0;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();

			pstmt = con.prepareStatement("DELETE FROM grosary WHERE name = ?");
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		} finally {
			System.out.println();
			try {
				pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

}
