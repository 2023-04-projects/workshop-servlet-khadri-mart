package com.khadri.mart.vegetable.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.mart.vegetable.dao.VegetableDao;
import com.khadri.mart.vegetable.form.VegetableForm;

public class ModifyVegetableServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VegetableDao dao;

	@Override
	public void init() {
		ServletContext context = getServletContext();
		dao = new VegetableDao(context);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Entered into ModifyVegetableServlet doPost(-,-)");

		String name = req.getParameter("veg_name");
		String qty = req.getParameter("veg_qty");
		String price = req.getParameter("veg_price");

		if (qty != null && !qty.isEmpty()) {
			try {
				Integer.parseInt(qty);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("Invalid qty format.");
			}
		} else {
			System.out.println("veg qty parameter is missing or empty.");
		}
		if (price != null && !price.isEmpty()) {
			try {
				Double.parseDouble(price);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("Invalid price format.");
			}
		} else {
			System.out.println("veg price parameter is missing or empty.");
		}
		VegetableForm form = new VegetableForm(name,Integer.parseInt(qty),Double.parseDouble(price));
		int result = dao.updateVegetables(form);
		PrintWriter pw = resp.getWriter();
		if (result > 0) {
			pw.println(result + " Vegetable updated successfully");
		} else {
			pw.println("####### Something went wrong #######");
		}
	}
}
