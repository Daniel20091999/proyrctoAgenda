package Clase;

public class Contactos {
	// Atributos
	String Nombre;
	String Apellido;
	String Direccion;
	String Email;
	String Telefono;

	// Constructor

	public Contactos(String nombre, String apellido, String dirreccion, String email, String telefono) {
		Nombre = nombre;
		Apellido = apellido;
		Direccion = dirreccion;
		Email = email;
		Telefono = telefono;
	}

	// Getters and Setters

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

}
