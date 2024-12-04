package com.khadri.mart.cosmotic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.khadri.mart.cosmotic.form.CosmoticForm;

public class CosmoticDao {

	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private String Url;
	private String User;
	private String Password;
	
	public CosmoticDao(ServletContext context) {
		this.Url = context.getInitParameter("Url");
		this.User = context.getInitParameter("User");
		this.Password = context.getInitParameter("Password");
	}

	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(Url, User, Password);
	}

	public int insertCosmotic(CosmoticForm form) {
		System.out.println("CosmoticDao insertCosmotic(-)");
		int result = 0;
		try {
			con = getConnection();

			pstmt = con.prepareStatement("INSERT INTO cosmotic VALUES(?,?,?,?)");

			pstmt.setString(1, form.getCategory());
			pstmt.setString(2, form.getName());
			pstmt.setInt(3, form.getQty());
			pstmt.setDouble(4, form.getPrice());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		} finally {
			System.out.println("Executed finally block");
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

	public int updateCosmotic(CosmoticForm form) {
		System.out.println("CosmoticDao updateCosmotic()");
		int rowsUpdated = 0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("UPDATE cosmotic SET category = ?, qty = ?, price = ? WHERE pname = ?");
			pstmt.setString(1, form.getCategory());
			pstmt.setInt(2, form.getQty());
			pstmt.setDouble(3, form.getPrice());
			pstmt.setString(4, form.getName());

			rowsUpdated = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Executed finally block");
			try {
				pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsUpdated;
	}

	public List<CosmoticForm> selectCosmotic(String name) {
		System.out.println("CosmoticDao selectCosmotic(-)");
		
		List<CosmoticForm> listOfSelectData = new ArrayList<>();
		try {
			con = getConnection();

			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from cosmotic where pname='" + name + "'");

			while (resultSet.next()) {
				CosmoticForm form = new CosmoticForm(resultSet.getString(1), resultSet.getString(2),
						resultSet.getInt(3), resultSet.getDouble(4));
				listOfSelectData.add(form);
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}finally {
			System.out.println("Executed finally block");
			try {
				pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfSelectData;
	}

	public List<CosmoticForm> selectAllcosmotic() {
		System.out.println("CosmoticDao selectAllCosmotic()");
		List<CosmoticForm> listOfAllCosmotic = new ArrayList<>();
		try {
			con = getConnection();

			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from cosmotic");

			while (resultSet.next()) {
				CosmoticForm form = new CosmoticForm(resultSet.getString(1), resultSet.getString(2),
						resultSet.getInt(3), resultSet.getDouble(4));
				listOfAllCosmotic.add(form);
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}finally {
			System.out.println();
			try {
				pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return listOfAllCosmotic;
	}
	
	public int deleteCosmotic(String name) {
		System.out.println("CosmoticDao deleteCosmotic(-)");
		int result = 0;
		try {
			con = getConnection();

			pstmt = con.prepareStatement("DELETE FROM cosmotic WHERE pname = ?");
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		} finally {
			System.out.println("Executed finally block");
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
