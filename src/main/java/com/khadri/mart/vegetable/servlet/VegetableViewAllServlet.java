package com.khadri.mart.vegetable.servlet;

import java.io.IOException;
import java.util.List;

import com.khadri.mart.vegetable.dao.VegetableDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VegetableViewAllServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VegetableDao vegetableDao;

	public void init() {

		vegetableDao = new VegetableDao();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.setAttribute("vegetableList", vegetableDao);

		req.getRequestDispatcher("/viewall.html").forward(req, resp);
	}

}
