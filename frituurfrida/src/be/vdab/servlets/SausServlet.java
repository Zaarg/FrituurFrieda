package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.dao.SausDAO;

@WebServlet(name="/sauzen.htm", urlPatterns="/sauzen.htm")
public class SausServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private static final String VIEW = "/WEB-INF/JSP/saus.jsp";
private final transient SausDAO sausDAO = new SausDAO();  
  
  @Resource(name = SausDAO.JNDI_NAME) void setDataSource(DataSource dataSource) {
	  sausDAO.setDataSource(dataSource); 
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setAttribute("sauzen", sausDAO.findAll()); 
	  request.getRequestDispatcher(VIEW).forward(request, response);
  }
  
} 