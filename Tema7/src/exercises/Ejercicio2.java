package exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import utils.Creedenciales;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		// Variable para almacenar el numero de filas afectadas
		int res;
		
		// Conectamos con la base de datos
		try (Connection con = DriverManager.getConnection(Creedenciales.url, Creedenciales.user, Creedenciales.password)) {
			
			// Creamos un statement para trabajar con la BD
			Statement st = con.createStatement();
			
			// Editamos el telefono del estudiante insertado anteriormente
			String setEstudiante = "UPDATE Estudiantes SET Telefono = 623960532 WHERE nombre = 'Roman'";
			res = st.executeUpdate(setEstudiante);
			System.out.println("table: Estudiantes -> Número de filas afectadas: " + res);
			
			// Editamos la especialidad del profesor insertado anteriormente
			String setProfesor = "UPDATE Profesores SET Especialidad = 'Lengua' WHERE nombre = 'Elena'";
			res = st.executeUpdate(setProfesor);
			System.out.println("table: Profesores -> Número de filas afectadas: " + res);
			
			// Editamos el año escolar del curso insertado anteriormente
			String setCurso = "UPDATE Cursos SET Año_escolar = 2026 WHERE nombre = 'Programacion'";
			res = st.executeUpdate(setCurso);
			System.out.println("table: Cursos -> Número de filas afectadas: " + res);
	
		// Mostramos un mensaje de error si no se puede conectar con la base de datos
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectar con la base de datos");
		}

	}

}
