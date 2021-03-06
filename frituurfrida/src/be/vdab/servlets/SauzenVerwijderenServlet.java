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

@WebServlet(name = "/sauzen/verijderen.htm", urlPatterns = "/sauzen/verwijderen.htm")
public class SauzenVerwijderenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REDIRECT_URL = "%s/sauzen.htm";
	private final transient SausDAO sausDAO = new SausDAO();

	@Resource(name = SausDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		sausDAO.setDataSource(dataSource);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (request.getParameterValues("nummer") != null) {
			for (String nummer : request.getParameterValues("nummer")) {
				sausDAO.verwijderSaus(Long.parseLong(nummer));
			}
		}
		response.sendRedirect(String.format(REDIRECT_URL, request.getContextPath()));
	}

}