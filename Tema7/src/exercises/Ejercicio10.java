package exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utils.Creedenciales;

public class Ejercicio10 {

	public static void main(String[] args) {

		// Variable para almacenar el id del curso introducido por el usuario
		int idCurso;
		
		// Variable para almacenar la consulta sql
		String sql;
		
		// Creamos el scanner para obtener el id del curso que introduzca el usuario
		Scanner reader = new Scanner(System.in);
		
		// Pedimos al usuario que introduzca el id del curso
		System.out.println("Introduzca el id del curso");
		idCurso = reader.nextInt();
		
		// Creamos la consulta para obtener los estudiantes del curso con el id introducido por el usuario
		sql = "SELECT * FROM Estudiantes WHERE id_estudiante IN (SELECT id_estudiante FROM Calificaciones WHERE id_curso = " + idCurso + ")";
		
		// Conectamos con la base de datos
		try (Connection con = DriverManager.getConnection(Creedenciales.URL, Creedenciales.USER, Creedenciales.PASSWORD)) {
			
			// Creamos un statement
			Statement st = con.createStatement();
			
			// Obtenemos los estudiantes
			ResultSet rs = st.executeQuery(sql);
			
			// Mostramos unicamente el nombre y la fecha de nacimiento
			while (rs.next()) {
				System.out.println(rs.getString(2) + "\t" + rs.getString(4));
			}
				
		// Capturamos la excepcion y mostramos un mensaje de error
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error en la conexión con la base de datos -> " + e.getMessage());
		}
		
		// Cerramos el scanner
		reader.close();
	}
}
