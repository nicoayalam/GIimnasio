package Entity;

public class Sala {

	int idSala;
	String nombre;
	String ubicacion;
	
public Sala (int idSala, String nombre, String ubicacion) {
	
	this.idSala = idSala;
	this.nombre = nombre;
	this.ubicacion = ubicacion;
	
}

public int getIdSala() {
	return idSala;
}

public void setIdSala(int idSala) {
	this.idSala = idSala;
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
	
}
