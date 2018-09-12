package Entity;

public class Grupo {

	int idGrupo;
	int idInstructor;
	double horario;
	int idClase;
	
	public Grupo(int idGrupo, int idInstructor, int idClase, double horario) {
		
		this.idGrupo = idGrupo;
		this.idInstructor = idInstructor;
		this.idClase = idClase;
		this.horario = horario;
		
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public int getIdInstructor() {
		return idInstructor;
	}

	public void setIdInstructor(int idInstructor) {
		this.idInstructor = idInstructor;
	}

	public int getIdClase() {
		return idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}
	
}
