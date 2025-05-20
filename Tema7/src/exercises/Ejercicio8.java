package exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utils.Creedenciales;

public class Ejercicio8 {

	public static void main(String[] args) {
		
		// Variable para almacenar el id del estudiante a eliminar
		int idEstudiante;
		
		// Creamos el scanner para obtener datos introducidos por el usuario
		Scanner reader = new Scanner(System.in);
		
		// Creamos la consulta
		String sql = "DELETE FROM Estudiantes WHERE id_estudiante = ";
		
		// Variable para almacenar el resultado de la consulta
		int res;
		
		// Pedimos al usuario que introduzca el id del estudiante a eliminar
		System.out.println("Introduzca el id del estudiante a eliminar");
		idEstudiante = reader.nextInt();
		
		// Conectamos con la base de datos
		try (Connection con = DriverManager.getConnection(Creedenciales.URL, Creedenciales.USER, Creedenciales.PASSWORD)) {
		
			// Creamos un statement
			Statement st = con.createStatement();
			
			// Ejecutamos la consulta
			res = st.executeUpdate(sql +  idEstudiante);
			
			// Mostramos el resultado
			System.out.println("table: Estudiantes -> Nº de filas afectadas " + res);
			
		// Capturamos la excepcion y mostramos un mensaje de error
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectar con la base de datos");
		}
		
		// Cerramos el scanner
		reader.close();
	}
}
