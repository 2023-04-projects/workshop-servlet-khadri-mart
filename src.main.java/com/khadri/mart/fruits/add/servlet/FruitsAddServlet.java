package com.khadri.mart.fruits.add.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.mart.fruits.dao.FruitsDao;
import com.khadri.mart.fruits.form.FruitsForm;

public class FruitsAddServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;
	private FruitsDao dao;
	 public void init() {
			ServletContext context = getServletContext();
			  dao = new FruitsDao(context);
	 }
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException { 
		 System.out.println("Entered into AddFruitsServlet doPost(-,-)");
	  String name = req.getParameter("item_name");  
	  String qty = req.getParameter("item_qty");
	  String price = req.getParameter("item_price");
	  FruitsForm form = new FruitsForm(name, Integer.parseInt(qty), Double.parseDouble(price));
	  int result = dao.insertFruits(form);
	  PrintWriter pw = resp.getWriter();
	  if (result == 1) {  
		  pw.println(result + " Inserted Successfully!!!!!");
	  } else {   pw.println("@@@@@Something went wrong@@@@@");
	  }
	 }

}
