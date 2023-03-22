package com.example.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Projet;

/**
 * Servlet implementation class PortfolioServlet
 */
@WebServlet("/PortfolioServlet")
public class PortfolioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private PortfolioDAO dao;

    public PortfolioServlet() throws SQLException {
        dao = new PortfolioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Projet item = dao.get(id);
            request.setAttribute("item", item);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } else {
            List<Projet> items = dao.getAll();
            request.setAttribute("items", items);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            Projet item = new Projet();
            item.setTitre(request.getParameter("name"));
            item.setDescription(request.getParameter("description"));
            item.setUrl(request.getParameter("url"));
            dao.add(item);
        } else if (action.equals("update")) {
        	Projet item = new Projet();
            item.setTitre(request.getParameter("name"));
            item.setDescription(request.getParameter("description"));
            item.setUrl(request.getParameter("url"));
            dao.update(item);
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
        }
        response.sendRedirect(request.getContextPath() + "/PortfolioServlet");
    }

}
