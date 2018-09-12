package Entity;

public class Vendedor {

	int idVendedor;
	int idPersona;
	double descuento;
	
	public Vendedor (int idVendedor, int idPersona, double descuento) {
		
		this.idVendedor = idVendedor;
		this.idPersona = idPersona;
		this.descuento = descuento;
		
		
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	
}
