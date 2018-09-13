package Entity;

public class Clase {
	
	int idClase;
	int idSala;
	String nombre;
	String ubicacion;
	
	public Clase (int idClase, int idSala, String nombre, String ubicacion) {
		
		this.idClase = idClase;
		this.idClase = idSala;
		this.ubicacion = ubicacion;
		this.nombre = nombre;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getIdClase() {
		return idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	
}
