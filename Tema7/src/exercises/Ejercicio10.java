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
		
		// Creamos la consulta para obtener el id de los estudiantes que cursan dicho curso
		String sql1 = "SELECT id_estudiante FROM Matriculas WHERE id_curso = ";
		
		// Creamos la consulta para obtener toda la tabla
		String sql2 = "SELECT * FROM Estudiantes WHERE id_estudiante = ";
		
		// Creamos el scanner para obtener el id del curso que introduzca el usuario
		Scanner reader = new Scanner(System.in);
		
		// Pedimos al usuario que introduzca el id del curso
		System.out.println("Introduzca el id del curso");
		idCurso = reader.nextInt();
		
		// Conectamos con la base de datos
		try (Connection con = DriverManager.getConnection(Creedenciales.URL, Creedenciales.USER, Creedenciales.PASSWORD)) {
			
			// Creamos un statement
			Statement st = con.createStatement();
			
			// Seleccionamos el id de los estudiantes
			ResultSet rs1 = st.executeQuery(sql1 + idCurso);
			
			// Obtenemos el id de los estudiantes y mostramos unicamente el nombre y la fecha de nacimiento
			while (rs1.next()) {
				
				// Ejecutamos la consulta y mostramos su resultado
				ResultSet rs2 = st.executeQuery(sql2 + rs1.getString(1));
				
				// Mostramos unicamente el nombre y la fecha de nacimiento
				while (rs2.next()) {
					System.out.println(rs2.getString(2) + "\t" + rs2.getString(4));
				}
			}
				
		// Capturamos la excepcion y mostramos un mensaje de error
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectar con la base de datos");
		}
		
		// Cerramos el scanner
		reader.close();
	}
}
