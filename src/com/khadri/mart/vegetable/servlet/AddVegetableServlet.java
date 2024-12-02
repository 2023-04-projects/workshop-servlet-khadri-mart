package com.khadri.mart.vegetable.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.mart.vegetable.dao.VegetableDao;
import com.khadri.mart.vegetable.form.VegetableForm;

public class AddVegetableServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VegetableDao dao;

	@Override
	public void init() throws ServletException {

		ServletContext context = getServletContext();
		dao = new VegetableDao(context);
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
