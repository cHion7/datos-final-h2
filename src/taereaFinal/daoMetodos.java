package taereaFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class daoMetodos {
	public void CrearTablaAlumnos() throws SQLException {
		Connection conexion = DriverManager
				.getConnection("jdbc:h2:C:\\Users\\metoj\\Desktop\\base de datos\\proyecto.db");
		PreparedStatement sentencia;
		sentencia = conexion
				.prepareStatement("CREATE TABLE IF NOT EXISTS BaseDatos (" + "Pais VARCHAR(30) PRIMARY KEY, "
						+ "Presidente VARCHAR(30), " + "PIB INTEGER, " + "coeficiente DOUBLE)");

		sentencia.execute();
		conexion.close();
	}

	public void guardarAlumno(Pais a) throws SQLException {
		Connection conexion = DriverManager
				.getConnection("jdbc:h2:C:\\Users\\metoj\\\\Desktop\\base de datos\\proyecto.db");
		PreparedStatement sentencia;
		ResultSet result;

		String nombre = a.getPais();
		String presi = a.getPresidente();
		int PIB = a.getPIB();
		double coeficiente = a.getCoeficiente();

		sentencia = conexion.prepareStatement("INSERT INTO BaseDatos VALUES(?, ?, ?, ?)");
		sentencia.setString(1, nombre);
		sentencia.setString(2, presi);
		sentencia.setInt(3, PIB);
		sentencia.setDouble(4, coeficiente);

		sentencia.executeUpdate();

	}

	public boolean existeAlumno(Pais a) throws SQLException {
		Connection conexion = DriverManager
				.getConnection("jdbc:h2:C:\\Users\\metoj\\Desktop\\base de datos\\proyecto.db");
		PreparedStatement sentencia;
		ResultSet result;

		String nombre = a.getPais();
		String presi = a.getPresidente();
		int PIB = a.getPIB();
		double coeficiente = a.getCoeficiente();

		sentencia = conexion.prepareStatement(
				"SELECT * FROM  BaseDatos WHERE Pais = ? and WHERE Presidente = ? and WHERE PIB = ? and WHERE coeficiente = ?");
		sentencia.setString(1, nombre);
		sentencia.setString(2, presi);
		sentencia.setInt(3, PIB);
		sentencia.setDouble(4, coeficiente);
		result = sentencia.executeQuery();

		if (result.next()) {
			return true;
		} else {

			return false;
		}

	}

	public void modificarPais(String a, String p) throws SQLException {
		Connection conexion = DriverManager
				.getConnection("jdbc:h2:C:\\Users\\metoj\\Desktop\\base de datos\\proyecto.db");
		PreparedStatement sentencia;

		String nombreActual = a;
		String nuevoNombre = p;
		
		sentencia = conexion.prepareStatement("UPDATE BaseDatos SET NOMBRE = ? WHERE NOMBRE = ?");
		sentencia.setString(1, nuevoNombre);
		sentencia.setString(2, nombreActual);
		int filasAfectadas = sentencia.executeUpdate();

		if (filasAfectadas > 0) {
			System.out.println("El pais ha sido modificado.");
		} else {
			System.out.println("No se encontró ningún pais con ese nombre.");
		}

		conexion.close();
	}

	public void modificarPresi(String a, String p) throws SQLException {
		Connection conexion = DriverManager
				.getConnection("jdbc:h2:C:\\Users\\metoj\\Desktop\\base de datos\\proyecto.db");
		PreparedStatement sentencia;

		String nombreActual = a;
		String nuevoNombre = p;

		sentencia = conexion.prepareStatement("UPDATE BaseDatos SET Presidente = ? WHERE Presidente = ?");
		sentencia.setString(1, nuevoNombre);
		sentencia.setString(2, nombreActual);
		int filasAfectadas = sentencia.executeUpdate();

		if (filasAfectadas > 0) {
			System.out.println("El PRESIDENTE ha sido modificado.");
		} else {
			System.out.println("No se encontró ningún PRESIDENTE con ese nombre.");
		}

		conexion.close();
	}

	public void modificarPIB(int a, int p) throws SQLException {
		Connection conexion = DriverManager
				.getConnection("jdbc:h2:C:\\Users\\metoj\\Desktop\\base de datos\\proyecto.db");
		PreparedStatement sentencia;

		int nombreActual = a;
		int nuevoNombre = p;

		sentencia = conexion.prepareStatement("UPDATE BaseDatos SET PIB = ? WHERE PIB = ?");
		sentencia.setInt(1, nuevoNombre);
		sentencia.setInt(2, nombreActual);
		int filasAfectadas = sentencia.executeUpdate();

		if (filasAfectadas > 0) {
			System.out.println("El PIB ha sido modificado.");
		} else {
			System.out.println("No se encontró ningún PIB con ese dato.");
		}

		conexion.close();
	}

	public void modificarCoeficiente(double a, double p) throws SQLException {
		Connection conexion = DriverManager
				.getConnection("jdbc:h2:C:\\Users\\metoj\\Desktop\\base de datos\\proyecto.db");
		PreparedStatement sentencia;

		double nombreActual = a;
		double nuevoNombre = p;

		sentencia = conexion.prepareStatement("UPDATE BaseDatos SET coeficiente = ? WHERE coeficiente = ?");
		sentencia.setDouble(1, nuevoNombre);
		sentencia.setDouble(2, nombreActual);
		int filasAfectadas = sentencia.executeUpdate();

		if (filasAfectadas > 0) {
			System.out.println("El COEFICIENTE ha sido modificado.");
		} else {
			System.out.println("No se encontró ningún COEFICIENTE cON ESE DATO.");
		}

		conexion.close();
	}

}