package exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import utils.Creedenciales;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		// Variable para almacenar el numero de filas afectadas
		int res;
		
		// Conectamos con la base de datos
		try (Connection con = DriverManager.getConnection(Creedenciales.URL, Creedenciales.USER, Creedenciales.PASSWORD)) {
			
			// Creamos un statement para trabajar con la BD
			Statement st = con.createStatement();
			
			// Eliminamos el estudiante insertado anteriormente
			String delEstudiante = "DELETE FROM Estudiantes WHERE nombre = 'Roman'";
			res = st.executeUpdate(delEstudiante);
			System.out.println("table: Estudiantes -> Número de filas afectadas: " + res);
			
			// Eliminamos el profesor insertado anteriormente
			String delProfesor = "DELETE FROM Profesores WHERE nombre = 'Elena'";
			res = st.executeUpdate(delProfesor);
			System.out.println("table: Profesores -> Número de filas afectadas: " + res);
			
			// Eliminamos el curso insertado anteriormente
			String delCurso = "DELETE FROM Cursos WHERE nombre = 'Programacion'";
			res = st.executeUpdate(delCurso);
			System.out.println("table: Cursos -> Número de filas afectadas: " + res);
	
		// Mostramos un mensaje de error si no se puede conectar con la base de datos
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectar con la base de datos");
		}

	}

}