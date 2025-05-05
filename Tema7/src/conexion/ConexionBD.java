package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost/institutodb";
		String user = "root";
		String password = "WhcUclRbb25";
				
				
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from estudiantes");
			
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
			}
			
		} catch (SQLException e) {
			System.out.println("Error al conectar con la base de datos");
		}
	}

}