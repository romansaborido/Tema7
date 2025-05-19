package exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import utils.Creedenciales;

public class Ejercicio1 {

	public static void main(String[] args) {
	
		// Variable para almacenar el numero de filas afectadas
		int res;
		
		// Conectamos con la base de datos
		try (Connection con = DriverManager.getConnection(Creedenciales.URL, Creedenciales.USER, Creedenciales.PASSWORD)) {
			
			// Creamos un statement para trabajar con la BD
			Statement st = con.createStatement();
			
			// Insertamos un nuevo estudiante
			String newEstudiante = "INSERT INTO Estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) VALUES ('Roman', 'Saborido', '2006-11-06', 'roman.saborido@email.com', 123498765)";
			res = st.executeUpdate(newEstudiante);
			System.out.println("table: Estudiantes -> Número de filas afectadas: " + res);
			
			// Insertamos un nuevo profesor
			String newProfesor = "INSERT INTO Profesores (nombre, apellido, especialidad, email) VALUES ('Elena', 'Rivero', 'Programacion', 'elena.rivero@email.com')";
			res = st.executeUpdate(newProfesor);
			System.out.println("table: Profesores -> Número de filas afectadas: " + res);
			
			// Insertamos un nuevo curso
			String newCurso = "INSERT INTO Cursos (nombre, descripcion, año_escolar) VALUES ('Programacion 1º', 'Curso de programacion de primer año', 2025)";
			res = st.executeUpdate(newCurso);
			System.out.println("table: Cursos -> Número de filas afectadas: " + res);
	
		// Mostramos un mensaje de error si no se puede conectar con la base de datos
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectar con la base de datos");
		}

	}

}
