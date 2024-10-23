package com.khadri.mart.vegetable.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.mart.vegetable.dao.VegetableDao;
import com.khadri.mart.vegetable.form.VegetableForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddVegetableServlet extends HttpServlet {

	private VegetableDao dao;

	@Override
	public void init() throws ServletException {
		dao = new VegetableDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into AddVegetableServlet doPost(-,-)");
		String name = req.getParameter("veg_name");
		String qty = req.getParameter("veg_qty");
		String price = req.getParameter("veg_price");

		VegetableForm form = new VegetableForm(name, Integer.parseInt(qty), Double.parseDouble(price));

		int result = dao.insertVegetable(form);

		PrintWriter pw = resp.getWriter();

		if (result == 1) {
			pw.println(result + " Inserted Successfully!!!!!");
		} else {
			pw.println("===========Something went wrong============");
		}

	}

}
