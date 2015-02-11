package com.ok.onlineshop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {

	private static final long	serialVersionUID	= 1L;

	public ControllerServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void
	doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.getSession().setAttribute("cart", cart);
		// new InitialContext.lookup("jndiName");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void
	doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
