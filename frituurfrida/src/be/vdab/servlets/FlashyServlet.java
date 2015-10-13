package be.vdab.servlets;

import java.io.IOException;
import java.lang.Math;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="flashyservlet", urlPatterns="/flashy.htm")
public class FlashyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String VIEW = "/WEB-INF/JSP/flashy.jsp";
  
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int red = (int)(Math.random()*255);
	  int green = (int)(Math.random()*255);
	  int blue = (int)(Math.random()*255);
	  request.setAttribute("red", red);
	  request.setAttribute("green", green);
	  request.setAttribute("blue", blue);
	  response.setIntHeader("Refresh", 1);
	  request.getRequestDispatcher(VIEW).forward(request, response);
  }
  
} 