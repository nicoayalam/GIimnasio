package Entity;

public class Persona {

	int idPersona;
	String nombre;
	String direccion;
	int telefono;
	int CI;
	
	public Persona(int idPersona, String nombre, String direccion, int telefono, int CI) {
		
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.CI = CI;
		
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getCI() {
		return CI;
	}

	public void setCI(int cI) {
		CI = cI;
	}
	
	
	
}
