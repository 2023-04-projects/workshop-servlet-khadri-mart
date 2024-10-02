package com.khadri.mart.grocessary.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.mart.grocessary.dao.GrossaryDao;
import com.khadri.mart.grocessary.form.GorsaryForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddGrossaryServlet extends HttpServlet {

	private GrossaryDao dao;

	@Override
	public void init() throws ServletException {
		dao = new GrossaryDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into AddGrossaryServlet doPost(-,-)");
		String name = req.getParameter("grocery_name");
		String qty = req.getParameter("grocery_qty");
		String price = req.getParameter("grocery_price");

		GorsaryForm form = new GorsaryForm(name, Integer.parseInt(qty), Double.parseDouble(price));

		int result = dao.insertGroossary(form);

		PrintWriter pw = resp.getWriter();

		if (result == 1) {
			pw.println(result + " Inserted Successfully!!!!!");
		} else {
			pw.println("@@@@@Something went wrong@@@@@");
		}

	}

}
