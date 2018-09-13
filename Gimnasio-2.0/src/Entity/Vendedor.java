package Entity;

public class Vendedor extends Persona{

	int idVendedor;
	int idPersona;
	double descuento;
	
	public Vendedor (int idVendedor, int idPersona, double descuento, String nombre, String direccion, int telefono, int CI) {
		
		super(idPersona, nombre, direccion, telefono, CI);
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
