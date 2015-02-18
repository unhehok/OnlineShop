package com.ok.onlineshop.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ok.onlineshop.manager.UserManager;

public class ControllerServlet extends HttpServlet {

	private static final long	serialVersionUID	= 1L;
	@EJB
	private UserManager				userManager;

	public ControllerServlet() {
	}

	@Override
	protected void
	doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");

	}

	@Override
	protected void
	doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		String newUsername = request.getParameter("newUsername");
		String newEmail = request.getParameter("newEmail");
		String newPassword = request.getParameter("newPassword");
		PrintWriter out = response.getWriter();

		switch (path) {
			case "/userRegistration.do":
				out.println("doPost path: " + path);
				out.println("newUsername: " + newUsername);
				out.println("newEmail: " + newEmail);
				out.println("newPassword: " + newPassword);
				this.userManager.newUser(newUsername, newPassword, newEmail);
		}

	}
}
