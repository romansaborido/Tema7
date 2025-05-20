package exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.Creedenciales;

public class Ejercicio9 {

	public static void main(String[] args) {
		
		// Creamos la consulta para obtener toda la tabla
		String sql = "SELECT * FROM Estudiantes";
		
		// Conectamos con la base de datos
		try (Connection con = DriverManager.getConnection(Creedenciales.URL, Creedenciales.USER, Creedenciales.PASSWORD)) {
		
			// Creamos un statement
			Statement st = con.createStatement();
			
			// Ejecutamos la consulta y almacenamos su resultado
			ResultSet rs = st.executeQuery(sql);
			
			// Mostramos unicamente el nombre y la fecha de nacimiento
			while (rs.next()) {
				System.out.println(rs.getString(2) + "\t" + rs.getString(4));
			}
			
		// Capturamos la excepcion y mostramos un mensaje de error
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectar con la base de datos");
		}
	}
}
