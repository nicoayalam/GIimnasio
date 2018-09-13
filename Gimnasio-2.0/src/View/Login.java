package View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Conexion.Consulta;

public class Login {
	Scanner sc = new Scanner(System.in);
	Consulta cons = new Consulta();
	
	public Login(){
		Inicio();
	}
	
	public void Inicio()
	{
		
		System.out.println("Elija un rol:");
		System.out.println("-------------------------------");
		System.out.println("1. Instructor");
		System.out.println("2. Vendedor");
		System.out.println("3. Cliente");
		int eleccion = sc.nextInt();
		switch (eleccion) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			Cliente();
			break;

		default:
			break;
		}

	}
	public void Cliente()
	{
		System.out.println("Elija una opcion:");
		System.out.println("------------------------------");
		System.out.println("1. Ver grupos inscritos");
		System.out.println("2. Ver grupos");
		System.out.println("3. Ver Membresias Vencidas");
		System.out.println("4. Ver Membresias Activas");
		int eleccion = sc.nextInt();
		switch (eleccion) {
		case 1:
			
			break;
		case 2:
			VerGrupos();
			break;
		case 3:
			System.out.println("Introduzca ID persona");
			int a = sc.nextInt();
			VerMembresia(a);
			break;
		case 4:
			System.out.println("Introduzca ID persona");
			int b = sc.nextInt();
			VerMembresiasActivas(b);
			break;
		default:
			break;
		}
	}
	private void VerMembresiasActivas(int a) {
		// TODO Auto-generated method stub
		ArrayList<String[]> membresias = cons.getMembresiaActiva(a);
		Iterator<String[]> it = membresias.iterator();
		
		while (it.hasNext()) {
			String[] membresia = it.next();
			System.out.println(membresia[0]+"/"+membresia[1]+"/"+membresia[2]+"/"+membresia[3]+"/"+membresia[4]);
		}
		
	}

	private void VerMembresia(int idPersona) {
		ArrayList<String[]> membresias = cons.getMembresiaVencida(idPersona);
		Iterator<String[]> it = membresias.iterator();
		
		while (it.hasNext()) {
			String[] membresia = it.next();
			System.out.println(membresia[0]+"/"+membresia[1]+"/"+membresia[2]+"/"+membresia[3]+"/"+membresia[4]);
		}
		
	}

	public void VerGrupos()
	{
		ArrayList<String[]> grupos = cons.getGrupos();
		Iterator<String[]> it = grupos.iterator();
		
		while (it.hasNext()) {
			String[] grupo = it.next();
			System.out.println(grupo[0]+"/"+grupo[1]+"/"+grupo[2]+"/"+grupo[3]+"/"+grupo[4]);
		}
	}
	
}
