package com.formigone.namemybaby.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends HttpServlet {

	private static final long serialVersionUID = -8720827749217003828L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
		rd.forward(req, resp);
	}
}
