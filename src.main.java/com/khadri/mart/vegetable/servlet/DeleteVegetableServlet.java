package com.khadri.mart.vegetable.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.mart.vegetable.dao.VegetableDao;

public class DeleteVegetableServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	private VegetableDao dao;

	@Override
	public void init() {
		ServletContext context = getServletContext();
		dao = new VegetableDao(context);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Entered into DeleteVegetableServlet doPost(-,-)");

		String name = req.getParameter("veg_name");
		
		System.out.println("Received 'name' parameter: " + name);
		
		if (name != null && !name.isEmpty()) {
			int result = dao.deleteVegetables(name);

			if (result > 0) {
				resp.getWriter().println("Vegetables item deleted successfully.");
			} else {
				resp.getWriter().println("Failed to delete vegetables item.");
			}
		} else {
			resp.getWriter().println("No vegetable items with this name.");
		}
	}
}


