package exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.Creedenciales;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		
		// Array de enteros para almacenar los resultados
		int res[];
		
		// Creamos la consulta
		String query = "INSERT INTO Cursos (nombre, descripcion, año_escolar) VALUES (?, ?, 2025)";
		
		// Conectamos con la base de datos
		try (Connection con = DriverManager.getConnection(Creedenciales.URL, Creedenciales.USER, Creedenciales.PASSWORD)) {
			
			// Creamos un preparedStatement
			PreparedStatement ps = con.prepareStatement(query);
			
			// Añadimos el curso historia
			ps.setString(1, "Historia 1º");
			ps.setString(2, "Historia de españa primer año");
			ps.addBatch();
			
			// Añadimos el curso biologia
			ps.setString(1, "Biología 1º");
			ps.setString(2, "Biología y geologia primer año");
			ps.addBatch();
			
			// Añadimos el curso educacion fisica
			ps.setString(1, "Educación Física 1º");
			ps.setString(2, "Educacion fisica y alimenticia primer año");
			ps.addBatch();
			
			// Añadimos el curso musica
			ps.setString(1, "Música 1º");
			ps.setString(2, "Musica creativa primer año");
			ps.addBatch();
			
			// Añadimos el curso tecnologia
			ps.setString(1, "Tecnología 1º");
			ps.setString(2, "Tecnologia compuesta y materias primer año");
			ps.addBatch();
			
			// Insertamos todos los cursos
			res = ps.executeBatch();
			
			// Mostramos los resultados
			System.out.println("query1: Número de filas afectadas -> " + res[0]);
			System.out.println("query2: Número de filas afectadas -> " + res[1]);
			System.out.println("query3: Número de filas afectadas -> " + res[2]);
			System.out.println("query4: Número de filas afectadas -> " + res[3]);
			System.out.println("query5: Número de filas afectadas -> " + res[4]);
			
		// Mostramos un mensaje de error si no se puede conectar a la BD
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectar con la base de datos");
		}
	}
}
