package com.khadri.mart.cosmotic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.mart.cosmotic.dao.CosmoticDao;
import com.khadri.mart.cosmotic.form.CosmoticForm;

public class ModifyCosmoticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CosmoticDao dao;

	@Override
	public void init() {
		ServletContext context = getServletContext();
		dao = new CosmoticDao(context);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Entered into ModifyCosmoticServlet doPost(-,-)");

		String category = req.getParameter("category");
		String name = req.getParameter("pname");
		String qty = req.getParameter("qty");
		String price = req.getParameter("price");

		if (qty != null && !qty.isEmpty()) {
			try {
				Integer.parseInt(qty);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("Invalid price format.");
			}
		} else {
			System.out.println("parameter is missing or empty.");
		}
		if (price != null && !price.isEmpty()) {
			try {
				Double.parseDouble(price);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("Invalid price format.");
			}
		} else {
			System.out.println(" parameter is missing or empty.");
		}

		CosmoticForm form = new CosmoticForm(category, name, Integer.parseInt(qty), Double.parseDouble(price));

		int result = dao.updateCosmotic(form);

		PrintWriter pw = resp.getWriter();

		if (result > 0) {
			pw.println(result + "Cosmotic updated successfully..!!!");
		} else {
			pw.println("####### Something went wrong #######");
		}
	}
}