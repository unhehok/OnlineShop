package com.ok.onlineshop.app;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Session Bean implementation class ShoppingCart
 */
@Stateless
@LocalBean
@WebService
public class ShoppingCart {

	/**
	 * Default constructor.
	 */
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}

	@WebMethod
	public String xys() {

		return "Hello";
	}

}
