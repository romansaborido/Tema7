package exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.Creedenciales;

public class Ejercicio6 {

	public static void main(String[] args) {
		
		// Sentencias sql para obtener el id estudiante y el id curso
		String getIdEstudiante = "SELECT id_estudiante FROM ESTUDIANTES WHERE nombre = 'Ana'";
		String getIdCurso = "SELECT id_curso FROM CURSOS WHERE nombre = 'Matemáticas 1º'";

		// Variables para almacenar el id del estudiante y el id del curso
		int idEstudiante = 0;
		int idCurso = 0;
		
		// Conectamos con la base de datos
		try (Connection con = DriverManager.getConnection(Creedenciales.URL, Creedenciales.USER, Creedenciales.PASSWORD)) {
			
			// Creamos un objeto tipo Statement
			Statement st = con.createStatement();
			
			// Obtenemos el id de Ana González
			ResultSet rs1 = st.executeQuery(getIdEstudiante);
			
			// Almacenamos el id del estudiante
			while (rs1.next()) {
				idEstudiante = rs1.getInt(1);
			}
			
			// Obtenemos el id de Matemáticas 1º
			ResultSet rs2 = st.executeQuery(getIdCurso);
			
			// Almacenamos el id del curso
			while (rs2.next()) {
				idCurso = rs2.getInt(1);
			}
			
			// Sumamos un punto en la nota
			st.executeUpdate("UPDATE CALIFICACIONES SET nota = nota + 1 WHERE id_estudiante = " + idEstudiante + " AND id_curso = " + idCurso);
			
			// Obtenemos la tabla estudiantes
			ResultSet rs3 = st.executeQuery("SELECT * FROM calificaciones");
		
			// Mostramos la tabla para verificar el resultado
			while (rs3.next()) {
				System.out.println(rs3.getInt(1) + "\t" + rs3.getInt(2) + "\t" + rs3.getInt(3) + "\t" + rs3.getInt(4) + "\t" + rs3.getString(5) + "\t" + rs3.getDouble(6) + "\t" + rs3.getString(7));
			}
			
		// Si ocurre un error al conectar con la BD mostramos este mensaje
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectar con la base de datos");
		}
		
	}
}
