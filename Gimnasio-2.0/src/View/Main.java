package View;

import java.util.ArrayList;
import java.util.Iterator;

import Conexion.Consulta;
import Entity.Instructor;
import Entity.Persona;
import Entity.Sala;

public class Main {

	public static void main(String[] args) {
		Consulta cons = new Consulta();
		
		
		cons.insertPersona("Felipe", "America", 546465, 46464);
		
		
		ArrayList<Sala> salas = cons.getSala();
		Iterator<Sala> it = salas.iterator();
		while(it.hasNext())
		{
			Sala s = it.next();
			System.out.println(s.getIdSala()+" "+s.getNombre()+" "+s.getUbicacion());
		}
		
		ArrayList<Persona> personas = cons.getPersona();
		Iterator<Persona> it2 = personas.iterator();
		while(it2.hasNext())
		{
			Persona p = it2.next();
			System.out.println(p.getIdPersona()+" "+p.getNombre()+" "+p.getDireccion()+" "+p.getTelefono()+" "+p.getCI());
		}
		
		ArrayList<Instructor> instructores = cons.getInstructor();
		Iterator<Instructor> it3 = instructores.iterator();
		while(it3.hasNext())
		{
			Instructor i = it3.next();
			System.out.println(i.getCI()+" "+ i.getDireccion()+" "+ i.getIdInstructor()+" "+i.getIdReferencia()+" "+i.getNombre()+" "+i.getTelefono());
		}
	}

}
