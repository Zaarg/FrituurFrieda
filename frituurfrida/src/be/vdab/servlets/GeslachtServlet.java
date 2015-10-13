package be.vdab.servlets;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="geslachtservlet", urlPatterns="/geslacht.htm")
public class GeslachtServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  private static final String VIEW = "/WEB-INF/JSP/geslacht.jsp";
  private static final String REDIRECT_URL = "%s/geslacht.htm";
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher(VIEW).forward(request, response);
  }
  
  @Override
  protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    Cookie cookie=new Cookie("geslacht", request.getParameter("meisjesjongens")); 
    cookie.setMaxAge(60 * 30); // 60 seconden x 30 = 30 minuten
    response.addCookie(cookie);
    response.sendRedirect(request.getRequestURI()); 
  }
}