package com.khadri.mart.cosmotic.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.mart.cosmotic.dao.CosmoticDao;

public class DeleteCosmoticServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CosmoticDao dao;
	
	@Override
	public void init() {
		ServletContext context = getServletContext();
		dao = new CosmoticDao(context);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("pname");
		System.out.println("Received 'name' parameter: " + name);

		if (name != null && !name.isEmpty()) {
			int result = dao.deleteCosmotic(name);

			if (result > 0) {
				resp.getWriter().println("Cosmotic Products Deleted successfully..!!!");
			} else {
				resp.getWriter().println("Failed to Delete Cosmotic Products..!!!");
			}
		} else {
			resp.getWriter().println("No Cosmotic Products with this name.");
		}
	}

}
