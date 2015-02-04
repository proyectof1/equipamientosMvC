package es.open4job.proyecto.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletPruebaSession
 */
public class ServletPruebaSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPruebaSession() {
		super();
	}

		protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// CONTROLADOR
		// parametros, validar y comprobar
		String num = (String) request.getParameter("id");
		int id = -1;

		try {
			id = Integer.parseInt(num);
		} catch (Exception e) {

		}

		if (id == -1) {
			// no hacemos nada si es nulo
		} else {

			boolean si = true;
			HttpSession session = request.getSession(si);
			session.setAttribute("idRecurso", id);

			request.getRequestDispatcher("ListarconSessionId.jsp").forward(
					request, response);

		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
