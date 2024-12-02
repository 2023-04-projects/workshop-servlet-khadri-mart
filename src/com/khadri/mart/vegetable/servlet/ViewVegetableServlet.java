package com.khadri.mart.vegetable.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.mart.vegetable.dao.VegetableDao;
import com.khadri.mart.vegetable.form.VegetableForm;

public class ViewVegetableServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VegetableDao dao;

	public void init() {
		ServletContext context = getServletContext();
		dao = new VegetableDao(context);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Entered into ViewVegetableServlet doPost(-,-)");
		String name = req.getParameter("veg_name");
		String qty = req.getParameter("veg_qty");
		String price = req.getParameter("veg_price");
		VegetableForm form = new VegetableForm(name, Integer.parseInt(qty), Double.parseDouble(price));
		List<VegetableForm> result = dao.selectVegetables(name);
		PrintWriter pw = resp.getWriter();

	}
}
