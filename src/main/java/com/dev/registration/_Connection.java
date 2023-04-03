package com.dev.registration;

import java.sql.Connection;
import java.sql.DriverManager;

public class _Connection {
	private static Connection connection;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3305/imdevelopper?useSSL=false","root","benaissa");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection methodConnection () {
		return connection;
	}

}
