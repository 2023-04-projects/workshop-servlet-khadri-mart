package com.khadri.mart.cosmotic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.mart.cosmotic.dao.CosmoticDao;
import com.khadri.mart.cosmotic.form.CosmoticForm;

public class AddCosmoticServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CosmoticDao dao;

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		dao = new CosmoticDao(context);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into AddCosmoticServlet doPost(-,-)");
		
		String category = req.getParameter("category");
		String name = req.getParameter("pname");
		String qty = req.getParameter("qty");
		String price = req.getParameter("price");

		CosmoticForm form = new CosmoticForm(category, name, Integer.parseInt(qty), Double.parseDouble(price));

		int result = dao.insertCosmotic(form);

				PrintWriter pw = resp.getWriter();

		if (result == 1) {
			pw.println(result + " Inserted Successfully..!!!");
		} else {
			pw.println("@@@@@Something went wrong@@@@@");
		}
	}
}
