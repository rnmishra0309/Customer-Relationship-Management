package com.crm.config.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/test_db")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/customer_db?useSSL=false";
	private static final String USER = "admin";
	private static final String PASSWORD = "admin";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName(DRIVER);
			out.println("The URL is: " + JDBC_URL);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			out.println("Connection Successful!!! " + conn.getCatalog());
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
