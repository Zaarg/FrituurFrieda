package be.vdab.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Adres;
import be.vdab.entities.Gemeente;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(name="indexservlet", urlPatterns="/index.htm")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	
	private final Adres adres = new Adres();
	  
	 /* public IndexServlet() { //in de constructor kunnen gegevens meegegeven worden aan de servlet
		  adres.setStraat("Diestsesteenweg");
		  adres.setHuisNr("622");
		  Gemeente gemeente = new Gemeente();
		  gemeente.setPostcode(3010);
		  gemeente.setNaam("Kessel-lo");
		  adres.setGemeente(gemeente); 
		}*/
	
	 	/**
		 * Haalt parameters uit de web.xml en kent ze toe aan object
		 */
	  @Override
	  public void init() throws ServletException {
		  ServletContext context = this.getServletContext();
		  adres.setStraat(context.getInitParameter("straat"));
		  adres.setHuisNr(context.getInitParameter("huisNr"));
		  Gemeente gemeente = new Gemeente();
		  gemeente.setPostcode(Integer.parseInt(context.getInitParameter("postcode")));
		  gemeente.setNaam(context.getInitParameter("gemeente"));
		  adres.setGemeente(gemeente);
	  } 
	 /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * setAttribute geeft gegevens door aan de webpagina
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dagVanDeWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		if (dagVanDeWeek == Calendar.FRIDAY || dagVanDeWeek == Calendar.THURSDAY) {
			request.setAttribute("openClosed","gesloten");
		} else {
			request.setAttribute("openClosed","open");
		}
		request.setAttribute("adres", adres);
		request.getRequestDispatcher(VIEW).forward(request, response); 
	}

}