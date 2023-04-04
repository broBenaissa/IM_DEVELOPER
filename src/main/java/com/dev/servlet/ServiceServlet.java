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

import com.example.model.Service;



@WebServlet("/")
public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceDAO serviceDAO;
	
	public void init() {
		serviceDAO = new ServiceDAO();
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
			case "/newS":
				showNewForm(request, response);
				break;
			case "/insert":
				insertService(request, response);
				break;
			case "/delete":
				deleteService(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateService(request, response);
				break;
			default:
				listService(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listService(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Service> listService = serviceDAO.selectAllServices();
		request.setAttribute("listService", listService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("service-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("service-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Service existingService = serviceDAO.selectService(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("service-form.jsp");
		request.setAttribute("service", existingService);
		dispatcher.forward(request, response);

	}

	private void insertService(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		Service newService = new Service(name, description, price);
		serviceDAO.insertService(newService);
		response.sendRedirect("listS");
	}

	private void updateService(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		Service book = new Service(id, name, description, price);
		serviceDAO.updateService(book);
		response.sendRedirect("listS");
	}

	private void deleteService(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		serviceDAO.deleteService(id);
		response.sendRedirect("listS");
	}
}
