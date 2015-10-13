package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import be.vdab.dao.SausDAO;
import be.vdab.entities.SausSpel;

@WebServlet("/raaddesaus.htm")
public class RaadDeSausServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String VIEW = "/WEB-INF/JSP/raaddesaus.jsp";
  private final transient SausDAO sausDAO = new SausDAO();
  
  @Resource(name = SausDAO.JNDI_NAME) void setDataSource(DataSource dataSource) {
	  sausDAO.setDataSource(dataSource); 
  }
  
  @Override
  protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
    HttpSession session = request.getSession();
    if (session.getAttribute("sausspel") == null) {
    	session.setAttribute("sausspel", new SausSpel(sausDAO));
    }
    request.getRequestDispatcher(VIEW).forward(request, response);
  }
  
  @Override 
  protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	  HttpSession session = request.getSession();
	  if (request.getParameter("nieuwspel") != null) {
		  session.removeAttribute("sausspel");
		  session.setAttribute("sausspel", new SausSpel(sausDAO));
	  }  
	  if (request.getParameter("gok") != null) {
	      SausSpel spel = (SausSpel) session.getAttribute("sausspel");
	      spel.raden(request.getParameter("gok"));
	      session.setAttribute("sausspel", spel);
      }
    response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
  }
} 
