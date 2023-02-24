package com.exemple.register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upass = request.getParameter("pass");
		String ucontact = request.getParameter("contact");
		RequestDispatcher dispatcher = null;
		Connection con= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginservlet","root","benaissa");
			PreparedStatement pst= con.prepareStatement("insert into users(uname,upass,uemail,ucontact)values(?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, upass);
			pst.setString(3, uemail);
			pst.setString(4, ucontact);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if(rowCount>0) {
				request.setAtribute("status","success");
			
			}else {
				request.setAttribute("status","failed");
			}
			dispatcher.forward(request,response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}

}
