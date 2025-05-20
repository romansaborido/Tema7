package exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import utils.Creedenciales;

public class Ejercicio7 {

	public static void main(String[] args) {
		
		// Creamos el scanner
		Scanner reader = new Scanner(System.in);
		
		// Variable para almacenar el nombre del estudiante a insertar
		String nombre;
		
		// Variable para almacenar el apellido del estudiante a insertar
		String apellido;
		
		// Variable para almacenar la fecha de nacimiento del estudiante a insertar
		String fecha_nacimiento;
		
		// Variable para almacenar el email del estudiante a insertar
		String email;
		
		// Variable para almacenar el numero de telefono del estudiante a insertar
		int telefono;
		
		// Variable para almacenar el resultado de la consulta
		int res;
		
		// Consulta insert into estudiantes
		String insert = "INSERT INTO Estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) VALUES (?,?,?,?,?)";
		
		
		// Pedimos al usuario que introduzca el nombre
		System.out.println("Introduzca el nombre del estudiante a insertar");
		nombre = reader.nextLine();
		
		// Pedimos al usuario que introduzca el apellido
		System.out.println("Introduzca el apellido del estudiante a insertar");
		apellido = reader.nextLine();
		
		// Pedimos al usuario que introduzca la fecha de nacimiento
		System.out.println("Introduzca la fecha de nacimiento del estudiante a insertar");
		fecha_nacimiento = reader.nextLine();
		
		// Pedimos al usuario que introduzca el email
		System.out.println("Introduzca el email del estudiante a insertar");
		email = reader.nextLine();
		
		// Pedimos al usuario que introduzca el telefono
		System.out.println("Introduzca el telefono del estudiante a insertar");
		telefono = reader.nextInt();
		
		
		// Conectamos con la base de datos
		try (Connection con = DriverManager.getConnection(Creedenciales.URL, Creedenciales.USER, Creedenciales.PASSWORD)) {
		
			// Creamos un prepared statement para introducir uno a uno los valores que ha proporcionado el usuario
			PreparedStatement ps = con.prepareStatement(insert);
	
			// Añadimos a la consulta los valores introducidos por el usuario
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, fecha_nacimiento);
			ps.setString(4, email);
			ps.setInt(5, telefono);
			
			// Ejecutamos el insert y almacenamos su resultado
			res = ps.executeUpdate();
			
			// Mostramos el resultado
			System.out.println("\ntable: Estudiantes -> Número de filas afectadas: " + res);
			
		// Capturamos la excepcion y mostramos un mensaje de error
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectar con la base de datos");
		}
		
		// Cerramos el scanner
		reader.close();
	}
}
