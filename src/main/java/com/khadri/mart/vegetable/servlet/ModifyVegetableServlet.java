package com.khadri.mart.vegetable.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.mart.vegetable.dao.VegetableDao;

public class ModifyVegetableServlet extends HttpServlet {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private VegetableDao dao;

	@Override
	public void init() {
		ServletContext context = getServletContext();
		dao = new VegetableDao(context);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Entered into ModifyClothesServlet doPost(-,-)");

		String name = req.getParameter("veg_name");
		String qtyStr = req.getParameter("veg_qty");
		String priceStr = req.getParameter("veg_price");

		PrintWriter pw = resp.getWriter();

		try {
			int qty = Integer.parseInt(qtyStr);
			double price = Double.parseDouble(priceStr);

			int result = dao.updateVegetablesItem(name, qty, price);

			if (result == 1) {
				pw.println(result + " Item Updated Successfully!!!!!");
			} else {
				pw.println("@@@@@ Something went wrong while updating the item @@@@@");
			}
		} catch (NumberFormatException e) {
			pw.println("@@@@@ Invalid input: Quantity and Price must be numeric @@@@@");
			e.printStackTrace();
		} catch (Exception e) {
			pw.println("@@@@@ Something went wrong: " + e.getMessage() + " @@@@@");
			e.printStackTrace();
		}
	}

}
