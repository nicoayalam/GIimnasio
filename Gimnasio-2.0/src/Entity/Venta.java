package Entity;

public class Venta {

	int idGrupo;
	int idMembresia;
	int idVendedor;
	double precio;
	
	
	public Venta(int idGrupo, int idMembresia, int idVendedor, double precio) {
		
	this.idGrupo = idGrupo;
	this.idMembresia = idMembresia;
	this.idVendedor = idVendedor;
	this.precio = precio;
		
	}


	public int getIdGrupo() {
		return idGrupo;
	}


	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}


	public int getIdMembresia() {
		return idMembresia;
	}


	public void setIdMembresia(int idMembresia) {
		this.idMembresia = idMembresia;
	}


	public int getIdVendedor() {
		return idVendedor;
	}


	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
}
