package es.open4job.proyecto.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.open4job.proyecto.model.dao.RecursosDAO;
import es.open4job.proyecto.model.vo.RecursosVO;

/**
 * Servlet implementation class svPruebaSessionId
 */
public class svPruebaSessionId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public svPruebaSessionId() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// CONTROLADOR
		// parametros, validar y comprobar
		boolean si = true;
		HttpSession session = request.getSession(si);
		Integer valorId = (Integer) session.getAttribute("idRecurso");

		if (valorId == -1) {
			// no hacemos nada si es nulo
		} else {

			// MODELO
			// daos, invocaciones con los aprametros y vo
			/*
			 * ESTA BIEN LO COMENTO PARA EL JNDI
			 * String driver = "oracle.jdbc.driver.OracleDriver";
			String host = "54.154.192.80";
			String puerto = "1521";
			String sid = "xe";
			String user = "open4job";
			String password = "open4job";
			String url = "jdbc:oracle:thin:" + user + "/" + password + "@"
					+ host + ":" + puerto + ":" + sid;

			RecursosDAO recursosDAO = new RecursosDAO(driver, url, user,
					password);
			*/
			RecursosDAO recursosDAO = new RecursosDAO();
			RecursosVO recurso = recursosDAO.getDatosRecurso(valorId);

			if (recurso == null) {
				PrintWriter out = response.getWriter();
				out.println("recurso nulo");
			} else {

				// VISTA

				//tb podria haber sido request.setAttribute("miRecurso", recurso);
				session.setAttribute("miRecurso", recurso);
			
				request.getRequestDispatcher("svListarconSession.jsp").forward(
						request, response);
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
