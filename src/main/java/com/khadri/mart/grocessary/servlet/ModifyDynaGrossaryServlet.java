package com.khadri.mart.grocessary.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.khadri.mart.grocessary.dao.GrossaryDao;
import com.khadri.mart.grocessary.form.GorsaryForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModifyDynaGrossaryServlet extends HttpServlet {

	private GrossaryDao dao;

	@Override
	public void init() throws ServletException {
		dao = new GrossaryDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into ModifyDynaGrossaryServlet doGet(-,-)");
		List<GorsaryForm> listOfGrossaries = new ArrayList<>();
		PrintWriter pw = resp.getWriter();
		String searchName = req.getParameter("grocery_name");
		
		if(searchName != null) {
		 listOfGrossaries = dao.selectGroossary(searchName);
		}
	

		StringBuffer sb = new StringBuffer();
		sb.append("<html><body><table><thead><h2>Search Grocery Item</h2></thead>");
		sb.append("<form action='gromodify' method='get'>");
		sb.append("<tbody><tr><td>Grocery Name:<input type='text' name='grocery_name'></td></tr>");
		sb.append("<tr><td><input type='submit' value='Search'></td></tr>");
		sb.append("<table border='1'>");
		sb.append("<thead>");
		sb.append("<tr>");
		sb.append("<th>Item</th>");
		sb.append("<th>Quantity</th>");
		sb.append("<th>Price</th>");
		sb.append("</tr>");
		sb.append("</thead>");
		sb.append("<tbody>");
		sb.append("<tbody>");

		listOfGrossaries.stream().forEach(eachForm -> {

			sb.append("<tr>");
			sb.append("<td><a href='bottom_right_gro_modify_1.html' target='bottom_right'> " + eachForm.getGrosaryName()
					+ "</a></td>");
			sb.append("<td>" + eachForm.getGrosaryQty() + "</td>");
			sb.append("<td>" + eachForm.getGrosaryPrice() + "</td>");
			sb.append("</tr>");
		});

		sb.append("</tbody>");
		
		pw.println(sb);

	}
}
