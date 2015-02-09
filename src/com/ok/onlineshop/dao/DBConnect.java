package com.ok.onlineshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private static Connection	con	= null;

	public static Connection getConnection() {
		if (DBConnect.con == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				DBConnect.con =
						DriverManager.getConnection("jdbc:oracle:thin:@6R26HX1:1521:ORCL",
								"unheh", "unheh");
			}
			catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return DBConnect.con;
	}

}
