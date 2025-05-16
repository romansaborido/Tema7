package exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.Creedenciales;

public class Ejercicio5 {

	public static void main(String[] args) {

		// Variable para almacenar la consulta estandar
		String query = "INSERT INTO Calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion) VALUES (?,?,?,?,?,'2025-05-16')";

		// Variable para almacenar los resultados de las inserciones
		int[] res;
		
		// Conectamos con la base de datos
		try (Connection con = DriverManager.getConnection(Creedenciales.url, Creedenciales.user, Creedenciales.password)) {

			// Creamos un PreparedStatement
			PreparedStatement ps = con.prepareStatement(query);

			// Añadimos la primera calificacion
			ps.setInt(1, 9);
			ps.setInt(2, 1);
			ps.setInt(3, 2);
			ps.setString(4, "Examen");
			ps.setDouble(5, 9.5);
			ps.addBatch();
			
			// Añadimos la segunda calificacion
			ps.setInt(1, 3);
			ps.setInt(2, 2);
			ps.setInt(3, 1);
			ps.setString(4, "Trabajo");
			ps.setDouble(5, 7.5);
			ps.addBatch();

			// Insertamos las dos calificaciones
			res = ps.executeBatch();

			// Mostramos los resultados
			System.out.println("calificacion1: Número de filas afectadas -> " + res[0]);
			System.out.println("calificacion2: Número de filas afectadas -> " + res[1]);

		// Si ocurre un error al conectar con la base de datos mostramos el siguiente mensaje
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer la conexión con la base de datos");
		}

	}

}
