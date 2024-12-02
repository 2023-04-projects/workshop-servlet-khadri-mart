package com.khadri.mart.vegetable.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.mart.vegetable.dao.VegetableDao;

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
		String qtyStr = req.getParameter("veg_qty");
		String priceStr = req.getParameter("veg_price");

		  System.out.println("Request parameters: ");
	        for (Enumeration<String> en = req.getParameterNames(); en.hasMoreElements();) {
	            String paramName = en.nextElement();
	            System.out.println(paramName + ": " + req.getParameter(paramName));
	        }

	        
	        System.out.println("veg_name: " + name);
	        System.out.println("veg_qty: " + qtyStr);
	        System.out.println("veg_price: " + priceStr);


	        PrintWriter pw = resp.getWriter();
	        
	        if (name == null || name.trim().isEmpty()) {
	            pw.println("@@@@@ Item name is missing @@@@@");
	            return;
	        }
	        if (qtyStr == null || qtyStr.trim().isEmpty()) {
	            pw.println("@@@@@ Quantity is missing @@@@@");
	            return;
	        }
	        if (priceStr == null || priceStr.trim().isEmpty()) {
	            pw.println("@@@@@ Price is missing @@@@@");
	            return;
	        }

		try {
			int qty = Integer.parseInt(qtyStr);
			double price = Double.parseDouble(priceStr);

			int result = dao.updateVegetables(name, qty, price);

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
