package exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.Creedenciales;

public class Ejercicio6 {

	public static void main(String[] args) {
		
		String getIdEstudiante = "SELECT id_estudiante FROM ESTUDIANTES WHERE nombre = 'Ana González'";
		String getIdCurso = "SELECT id_curso FROM CURSOS WHERE nombre = 'Matemáticas 1º'";

		// Conectamos con la base de datos
		try (Connection con = DriverManager.getConnection(Creedenciales.URL, Creedenciales.USER, Creedenciales.PASSWORD)) {
		
			// Creamos un objeto tipo Statement
			Statement st = con.createStatement();
			
			// Obtenemos el id de Ana González
			ResultSet idEstudiante = st.executeQuery(getIdEstudiante);
			
			// Obtenemos el id de Matemáticas 1º
			ResultSet idCurso = st.executeQuery(getIdCurso);
			
			// Sumamos un punto en la nota
			st.executeUpdate("SET CALIFICACIONES WHERE id_estudiante");
			
		// Si ocurre un error al conectar con la BD mostramos este mensaje
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectar con la base de datos");
		}
		
	}
}
