package es.open4job.proyecto.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.open4job.proyecto.model.dao.RecursosDAO;
import es.open4job.proyecto.model.vo.RecursosVO;

/**
 * Servlet implementation class servletPrueba
 */
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPrueba() {
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
		String num = (String) request.getParameter("id");
		int id = -1;

		try {
			id = Integer.parseInt(num);
		} catch (Exception e) {

		}

		if (id == -1) {
			// no hacemos nada si es nulo
		} else {

			// MODELO
			// daos, invocaciones con los aprametros y vo
			String driver = "oracle.jdbc.driver.OracleDriver";
			String host = "54.154.192.80";
			String puerto = "1521";
			String sid = "xe";
			String user = "open4job";
			String password = "open4job";
			String url = "jdbc:oracle:thin:" + user + "/" + password + "@"
					+ host + ":" + puerto + ":" + sid;

			RecursosDAO recursosDAO = new RecursosDAO(driver, url, user,
					password);
			RecursosVO recurso = recursosDAO.getDatosRecurso(id);

			if (recurso == null) {
				PrintWriter out = response.getWriter();
				out.println("recurso nulo");
			} else {

				// VISTA

				// busqueda de 1 recurso en concreto
				/*
				 * PrintWriter out = response.getWriter();
				 * out.println("<html>"); out.println("<body>");
				 * out.println("\n busqueda del recurso " +id);
				 * out.println(recurso.getId());
				 * out.println(recurso.getTitulo());
				 * out.println(recurso.getLatitud());
				 * out.println(recurso.getLongitud()); //
				 * recursosDAO.getDatosRecurso(730);
				 */

				// lo listaremos en vez de aquí en el jsp de ListarRecurso

				request.setAttribute("lalala", recurso);
				request.getRequestDispatcher("ListarRecurso.jsp").forward(
						request, response);
			}
		}// fin else
	}

}
