package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.entities.FrietSpel;

@WebServlet("/zoekdefriet.htm")
public class ZoekDeFrietServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/zoekdefriet.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("frieten") == null) {
			session.setAttribute("gevonden", false);
			session.setAttribute("frieten", new FrietSpel());
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameter("nieuwspel") != null) {
			session.removeAttribute("frieten");
			session.setAttribute("frieten", new FrietSpel());
			session.setAttribute("gevonden", false);
		}
		if (request.getParameter("volgnummer") != null) {
			long id = Long.parseLong(request.getParameter("volgnummer"));
			FrietSpel spel = (FrietSpel) session.getAttribute("frieten");
			spel.kiezen(id);
			if (spel.isDeWareFriet(id)) {
				session.setAttribute("gevonden", true);
			}
		}
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
	}
}
