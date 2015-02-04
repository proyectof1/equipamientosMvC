package es.open4job.proyecto.model.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.logging.Level;

import es.open4job.proyecto.model.vo.RecursosVO;

public class RecursosDAO extends GenericDAO {

	public static final Logger logger = Logger.getLogger(RecursosDAO.class
			.getName());

	// constructor

	public RecursosDAO() {

	}

	public RecursosDAO(String driver, String url, String user, String password) {
		super(driver, url, user, password);
		// TODO Auto-generated constructor stub
	}

	// Listado de recursos
	public List<RecursosVO> getListadoRecursos() {

		List<RecursosVO> recursos = new ArrayList<RecursosVO>();

		String query = "SELECT * FROM RECURSO";
		// String query = "SELECT ID, TITULO, LATITUD, LONGITUD FROM RECURSO";

		Statement st = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();
			st = connection.createStatement();
			rs = st.executeQuery(query);
			// rs = connection.createStatement().executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt(1);
				float latitud = rs.getFloat(2);
				float longitud = rs.getFloat(3);
				String servicios = rs.getString(4);
				String horario = rs.getString(5);
				String titulo = rs.getString(6);
				String descripcion = rs.getString(7);
				String gradoacc = rs.getString(8);
				String tipo = rs.getString(9);
				String relacionado = rs.getString(10);
				String clasificación = rs.getString(11);
				String precio = rs.getString(12);
				String email = rs.getString(13);
				String url = rs.getString(14);
				String accesibilidad = rs.getString(15);
				String poblacion = rs.getString(16);
				String telefono = rs.getString(17);

				RecursosVO recurso = new RecursosVO(id, latitud, longitud,
						servicios, horario, titulo, descripcion, gradoacc,
						tipo, relacionado, clasificación, precio, email, url,
						accesibilidad, poblacion, telefono);
				recursos.add(recurso);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
		this.cerrarConexion();

		return recursos;
	}

	// Obtiene los datos de un registro en concreto
	public RecursosVO getDatosRecurso(int idEquipo) {

		RecursosVO recurso = null;

		/*
		 * version cn el createStatement String query =
		 * "SELECT ID, TITULO, LATITUD, LONGITUD FROM RECURSO WHERE ID = " +
		 * idEquipo;
		 * 
		 * Statement st = null; ResultSet rs = null;
		 */

		// version cn el PreparedStatement
		String query = "SELECT ID, TITULO, LATITUD, LONGITUD FROM RECURSO WHERE ID = ? ";

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			// this.abrirConexion(); FUNCIONA BIEN LO COMENTO POR HACERLO CN EL
			// JNDI
			this.abrirConexionJNDI();

			// version 1 linea del createStatement
			// rs = connection.createStatement().executeQuery(query);

			/*
			 * version cn el createStatement st = connection.createStatement();
			 * rs = st.executeQuery(query);
			 */

			// version cn el PreparedStatement
			st = connection.prepareStatement(query);
			st.setInt(1, idEquipo);
			rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String titulo = rs.getString(2);
				float latitud = rs.getFloat(3);
				float longitud = rs.getFloat(4);

				// RecursosVO recurso = new RecursosVO(id, titulo, latitud,
				// longitud);
				// recursos.add(recurso);
				recurso = new RecursosVO(id, latitud, longitud, null, null,
						titulo, null, null, null, null, null, null, null, null,
						null, null, null);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
		this.cerrarConexion();

		return recurso;

	}

	// insertar un nuevo recurso
	public RecursosVO setInsertDatosRecurso() {

		RecursosVO recurso = null;

		String query = "INSERT INTO RECURSO(ID, TITULO, LATITUD, LONGITUD) VALUES (?, ?, ?, ?)";

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();

			// version 1 linea del createStatement
			// rs = connection.createStatement().executeQuery(query);

			/*
			 * version cn el createStatement st = connection.createStatement();
			 * rs = st.executeQuery(query);
			 */

			// version cn el PreparedStatement
			st = connection.prepareStatement(query);
			st.setInt(1, 11);
			st.setString(2, "insert1");
			st.setFloat(3, (float) 111.11);
			st.setFloat(4, (float) 222.222);

			// devuelve num filas insertadas
			int numFileUpdateadas = 0;
			numFileUpdateadas = st.executeUpdate();

			/*
			 * while (rs.next()) { int id = rs.getInt(1); String titulo =
			 * rs.getString(2); float latitud = rs.getFloat(3); float longitud =
			 * rs.getFloat(4);
			 * 
			 * // RecursosVO recurso = new RecursosVO(id, titulo, latitud, //
			 * longitud); // recursos.add(recurso); recurso = new RecursosVO(id,
			 * latitud, longitud, null, null, null, null, null, null, null,
			 * null, null, null, null, null, null, null); }
			 */

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
		this.cerrarConexion();

		return recurso;

	}

	// update de 1 recurso
	public RecursosVO setUpdateDatosRecurso(int idEquipo) {

		RecursosVO recurso = null;

		/*
		 * version cn el createStatement String query =
		 * "SELECT ID, TITULO, LATITUD, LONGITUD FROM RECURSO WHERE ID = " +
		 * idEquipo;
		 * 
		 * Statement st = null; ResultSet rs = null;
		 */

		// version cn el PreparedStatement
		String query = "UPDATE RECURSO SET TITULO = ? WHERE ID = ? ";

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();

			// version 1 linea del createStatement
			// rs = connection.createStatement().executeQuery(query);

			/*
			 * version cn el createStatement st = connection.createStatement();
			 * rs = st.executeQuery(query);
			 */

			// version cn el PreparedStatement
			st = connection.prepareStatement(query);
			st.setString(1, "pruUpdate");
			st.setInt(2, idEquipo);

			// devuelve num de filas modificadas
			int numFileUpdateadas = 0;
			numFileUpdateadas = st.executeUpdate();

			/*
			 * while (rs.next()) { int id = rs.getInt(1); String titulo =
			 * rs.getString(2); float latitud = rs.getFloat(3); float longitud =
			 * rs.getFloat(4);
			 * 
			 * // RecursosVO recurso = new RecursosVO(id, titulo, latitud, //
			 * longitud); // recursos.add(recurso); recurso = new RecursosVO(id,
			 * latitud, longitud, null, null, null, null, null, null, null,
			 * null, null, null, null, null, null, null); }
			 */

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
		this.cerrarConexion();

		return recurso;

	}

	// siguiente
	public int getSiguiente(int idEquipo) {

		// llamar al procedimiento almacenado de oracle

		CallableStatement cs = null;
		// PreparedStatement st = null;
		// ResultSet rs = null;

		int num = 0;

		try {

			this.abrirConexion();

			// version 1 linea del createStatement
			// rs = connection.createStatement().executeQuery(query);

			/*
			 * version cn el createStatement st = connection.createStatement();
			 * rs = st.executeQuery(query);
			 */

			// version cn el PreparedStatement
			/*
			 * st = connection.prepareStatement(query); st.setInt(1, idEquipo);
			 * rs = st.executeQuery();
			 */
			// LA FUNCION SIGUIENTE LA CREO PACO EN LA BD DE ORACLE
			cs = connection.prepareCall("{? =call SIGUIENTE(?) }");

			// declaracion 1º ? que devuelve int (OUT)
			cs.registerOutParameter(1, java.sql.Types.INTEGER);

			// resto ? (IN)
			cs.setInt(2, idEquipo);

			// ejecutar
			cs.executeQuery();
			// recoger valor obtenido
			num = cs.getInt(1);

			/*
			 * while (rs.next()) { int id = rs.getInt(1); String titulo =
			 * rs.getString(2); float latitud = rs.getFloat(3); float longitud =
			 * rs.getFloat(4);
			 * 
			 * // RecursosVO recurso = new RecursosVO(id, titulo, latitud, //
			 * longitud); // recursos.add(recurso); recurso = new RecursosVO(id,
			 * latitud, longitud, null, null, titulo, null, null, null, null,
			 * null, null, null, null, null, null, null);
			 * 
			 * 
			 * }
			 */

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (Exception e) {
				}
			}
			if (cs != null) {
				try {
					cs.close();
				} catch (Exception e) {
				}
			}
		}
		this.cerrarConexion();

		return num;

	}

	// insertar generico, para usar en las transacciones
	public RecursosVO setInsertarRecursos(int id, String titulo, float lati,
			float longi) {

		RecursosVO recurso = null;

		String query = "INSERT INTO RECURSO(ID, TITULO, LATITUD, LONGITUD) VALUES (?, ?, ?, ?)";

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			// this.abrirConexion(); la llamo en la transaccion

			// version cn el PreparedStatement
			st = connection.prepareStatement(query);
			st.setInt(1, id);
			st.setString(2, titulo);
			st.setFloat(3, lati);
			st.setFloat(4, longi);

			// devuelve num filas insertadas
			int numFileUpdateadas = 0;
			numFileUpdateadas = st.executeUpdate();

			/*
			 * while (rs.next()) { int id = rs.getInt(1); String titulo =
			 * rs.getString(2); float latitud = rs.getFloat(3); float longitud =
			 * rs.getFloat(4);
			 * 
			 * // RecursosVO recurso = new RecursosVO(id, titulo, latitud, //
			 * longitud); // recursos.add(recurso); recurso = new RecursosVO(id,
			 * latitud, longitud, null, null, null, null, null, null, null,
			 * null, null, null, null, null, null, null); }
			 */

			/*
			 * } catch (ClassNotFoundException e) { e.printStackTrace();
			 * logger.log(Level.SEVERE, "ClassNotFoundException : " +
			 * e.getMessage());
			 */
		} catch (SQLException e) {
			this.cerrarConexion();
			e.printStackTrace();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}

		// this.cerrarConexion();

		return recurso;

	}

	public boolean ejTransacciones() {

		Boolean verdad = true;
		try {

			this.abrirConexionTransaccion();

			RecursosVO r1 = null;
			RecursosVO r2 = null;
			RecursosVO r3 = null;
			r1 = setInsertarRecursos(55, "la5", 555, 555);
			r2 = setInsertarRecursos(66, "la6", 666, 666);
			r3 = setInsertarRecursos(77, "la7", 777, 777);

			// random
			Random r = new Random();
			int valor = r.nextInt(10);
			// int valor = r.nextInt(10)+1;
			System.out.println("random " + valor);

			if (valor % 2 == 0) {
				// par
				connection.commit();
				verdad = true;
			} else {
				// impar
				connection.rollback();
				verdad = false;

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		this.cerrarConexion();
		return verdad;

	}

}
