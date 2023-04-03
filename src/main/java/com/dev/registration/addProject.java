package com.dev.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import com.example.model.Projet;

/**
 * Servlet implementation class addProject
 */
@WebServlet("/save")
public class addProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addProject() {
        super();
        // TODO Auto-generated constructor stub
    }

    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//RequestDispatcher dispatcher =request.getRequestDispatcher("/add.jsp");
	//	dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get_paramerters
		    String titre = request.getParameter("titre");
	        String description = request.getParameter("description");
	        String lien = request.getParameter("lien");
	        
	        
	        
			Connection con= null;
			con = _Connection.methodConnection();
			Projet item = new Projet();
			
			//item.setTitre(titre);
			//item.setDescription(description);
			//item.setUrl(lien);
			
			  try {
		            PreparedStatement statement = con.prepareStatement("INSERT INTO projects (pid, pname, pdescription, pimg) VALUES (?, ?, ?, ?)");
		            statement.setInt(1,item.getId());
		            statement.setString(2, item.getTitre());
		            statement.setString(3, item.getDescription());
		            statement.setString(4, item.getUrl());
		            statement.executeUpdate();
		            
		            int rowCount = statement.executeUpdate();
					
					
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			  
	}

}
