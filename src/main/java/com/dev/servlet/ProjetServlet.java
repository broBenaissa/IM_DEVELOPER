package com.dev.servlet;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.ProjetDAO;
import com.dev.model.Projet;



@WebServlet("/")
public class ProjetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjetDAO projetDAO;
	
	public void init() {
		projetDAO = new ProjetDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertProjet(request, response);
				break;
			case "/delete":
				deleteProjet(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateProjet(request, response);
				break;
			default:
				listProjet(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listProjet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Projet> listProjet = projetDAO.selectAllProjets();
		request.setAttribute("listProjet", listProjet);
		RequestDispatcher dispatcher = request.getRequestDispatcher("projet-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("projet-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Projet existingProjet = projetDAO.selectProjet(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("projet-form.jsp");
		request.setAttribute("Projet", existingProjet);
		dispatcher.forward(request, response);

	}

	private void insertProjet(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String image = request.getParameter("image");
		Projet newProjet = new Projet(name, description, image);
		projetDAO.insertProjet(newProjet);
		response.sendRedirect("list");
	}

	private void updateProjet(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String image = request.getParameter("image");
		Projet book = new Projet(id, name, description, image);
		projetDAO.updateProjet(book);
		response.sendRedirect("list");
	}

	private void deleteProjet(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		projetDAO.deleteProjet(id);
		response.sendRedirect("list");
	}
}
