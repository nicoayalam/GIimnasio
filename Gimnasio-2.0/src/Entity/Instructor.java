package Entity;

public class Instructor extends Persona {

	int idInstructor;
	int idPersona;
	int idReferencia;
	
	public Instructor (int idInstructor, int idPersona, int idReferencia, String direccion, int telefono, String nombre, int CI) {
		
		super(idPersona, nombre, direccion, telefono, CI);
		this.idInstructor = idInstructor;
		this.idPersona = idPersona;
		this.idReferencia = idReferencia;
		
	}

	public int getIdInstructor() {
		return idInstructor;
	}

	public void setIdInstructor(int idInstructor) {
		this.idInstructor = idInstructor;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getIdReferencia() {
		return idReferencia;
	}

	public void setIdReferencia(int idReferencia) {
		this.idReferencia = idReferencia;
	}
	
}
