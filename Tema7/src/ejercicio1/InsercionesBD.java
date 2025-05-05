package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsercionesBD {

	public static void main(String[] args) {
	
		String url = "jdbc://localhost/institutodb";
		String user = "root";
		String password = "WhcUclRbb25";
		
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			
			Statement st = con.createStatement();
			
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectar con la base de datos");
		}

	}

}
