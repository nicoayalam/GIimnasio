package View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Conexion.Consulta;

public class Login {
	Scanner sc = new Scanner(System.in);
	Consulta cons = new Consulta();

	public Login() {
		Inicio();
	}

	public void Inicio() {

		System.out.println("Elija un rol:");
		System.out.println("-------------------------------");
		System.out.println("1. Instructor");
		System.out.println("2. Vendedor");
		System.out.println("3. Cliente");
		System.out.println("0. Salir");
		int eleccion = sc.nextInt();
		switch (eleccion) {
		case 1:
			Instructor();
			break;
		case 2:
			Vendedor();
			break;
		case 3:
			Cliente(); 
			break;
		case 0:
			System.out.println("Hasta luego!");
			break;

		default:
			break;
		}

	}

	private void Vendedor() {
		System.out.println("Elija funcion:");
		System.out.println("-------------------------------");
		System.out.println("1. Realizar Venta");
		System.out.println("2. Ver Ventas");
		System.out.println("3. Total Ventas");
		System.out.println("0. Atras");
		int eleccion = sc.nextInt();
		switch (eleccion) {
		case 1:
			RealizarVenta();
			break;
		case 2:
			VerVentas();
			break;
		case 3:
			VentasTotales();
			break;
		case 0:
			Inicio();
			break;
		default:
			break;
		}

	}

	private void VentasTotales() {
		
		
		

		ArrayList<String[]> res = cons.getTotalVentas();
		Iterator<String[]> it = res.iterator();

		while (it.hasNext()) {
			String[] tes = it.next();
			System.out.println(tes[0] + "/" + tes[1] );
		}
		System.out.println("Para volver, presione una tecla");
		sc.next();
		Vendedor();
	}

	private void VerVentas() {
		System.out.println("Introduzca ID vendedor");
		int a = sc.nextInt();

		ArrayList<String[]> res = cons.getVentasPorVendedor(a);
		Iterator<String[]> it = res.iterator();

		while (it.hasNext()) {
			String[] tes = it.next();
			System.out.println(tes[0] + "/" + tes[1] + "/" + tes[2] + "/" + tes[3]);
		}
		System.out.println("Para volver, presione una tecla");
		sc.next();
		Vendedor();

		
		
	}

	private void RealizarVenta() {
		System.out.println("Bienvenidos al sistema de ventas");
		System.out.println("Elija una opcion:");
		System.out.println("------------------------------");
		System.out.println("1. Realizar Venta Premium");
		System.out.println("2. Realizar Venta Standard");
		System.out.println("0. Atras");
		int eleccion = sc.nextInt();
		switch (eleccion) {
		case 1:
			RealizarVentaPremium();
			break;
		case 2:
			RealizarVentaStandard();
			break;
		case 0:
			Vendedor();
			break;

		default:
			break;
		}
	}
	

	private void RealizarVentaPremium() {
		System.out.println("Introduzca id del cliente a vender");
		int idPersona = sc.nextInt();
		cons.realizarVentaPremium(idPersona);
		System.out.println("Se creo la membresia con ID: "+cons.getUltimoIDMembresia());
		System.out.println("Inserte ID del grupo a vender");
		int idGrupo = sc.nextInt();
		System.out.println("Inserte ID del vendedor");
		int idVendedor = sc.nextInt();
		System.out.println("Inserte ID de la membresia vendida");
		int idMembresia = sc.nextInt();
		System.out.println("Inserte Precio de la venta");
		double precio = sc.nextDouble();
		cons.insertarVenta(idGrupo, idMembresia, idVendedor, precio);
		System.out.println("Venta realizada!");
		System.out.println("Para volver, presione una tecla");
		sc.next();
		Vendedor();
	}
	private void RealizarVentaStandard() {
		System.out.println("Introduzca id del cliente a vender");
		int idPersona = sc.nextInt();
		cons.realizarVentaStandard(idPersona);
		System.out.println("Se creo la membresia con ID: "+cons.getUltimoIDMembresia());
		System.out.println("Inserte ID del grupo a vender");
		int idGrupo = sc.nextInt();
		System.out.println("Inserte ID del vendedor");
		int idVendedor = sc.nextInt();
		System.out.println("Inserte ID de la membresia vendida");
		int idMembresia = sc.nextInt();
		System.out.println("Inserte Precio de la venta");
		double precio = sc.nextDouble();
		cons.insertarVenta(idGrupo, idMembresia, idVendedor, precio);
		System.out.println("Venta realizada!");
		System.out.println("Para volver, presione una tecla");
		sc.next();
		Vendedor();
		
	}

	public void Instructor() {
		System.out.println("Elija una opcion:");
		System.out.println("------------------------------");
		System.out.println("1. Ver grupos en los que das clase");
		System.out.println("2. Ver informacion del referente");
		System.out.println("0. Atras");
		int eleccion = sc.nextInt();
		switch (eleccion) {
		case 1:
			VerGruposInstructor();
			break;
		case 2:
			VerInformacionReferente();
			break;
		case 0:
			Inicio();
			break;

		default:
			break;
		}
	}

	private void VerGruposInstructor() {
		System.out.println("Introduzca ID instructor");
		int a = sc.nextInt();

		ArrayList<String[]> res = cons.getGrupoInstructor(a);
		Iterator<String[]> it = res.iterator();

		while (it.hasNext()) {
			String[] tes = it.next();
			System.out.println(tes[0] + "/" + tes[1] + "/" + tes[2] + "/" + tes[3]);
			
		}
		System.out.println("Para volver, presione una tecla");
		sc.next();
		Instructor();
	}

	public void VerInformacionReferente() {
		System.out.println("Introduzca ID instructor");
		int a = sc.nextInt();

		ArrayList<String[]> res = cons.getInformacionReferente(a);
		Iterator<String[]> it = res.iterator();

		while (it.hasNext()) {
			String[] tes = it.next();
			System.out.println(tes[0] + "/" + tes[1] + "/" + tes[2] + "/" + tes[3]);
		}
		System.out.println("Para volver, presione una tecla");
		sc.next();
		Instructor();
	}

	public void Cliente() {
		System.out.println("Elija una opcion:");
		System.out.println("------------------------------");
		System.out.println("1. Ver grupos inscritos");
		System.out.println("2. Ver grupos");
		System.out.println("3. Ver Membresias Vencidas");
		System.out.println("4. Ver Membresias Activas");
		System.out.println("0. Atras");
		int eleccion = sc.nextInt();
		switch (eleccion) {
		case 1:
			System.out.println("Introduzca ID persona");
			int c = sc.nextInt();
			VerGruposIncritos(eleccion);
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
		case 0:
			Inicio();
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
			System.out.println(
					membresia[0] + "/" + membresia[1] + "/" + membresia[2] + "/" + membresia[3] + "/" + membresia[4]);
		}
		System.out.println("Para volver, presione una tecla");
		sc.next();
		Cliente();
	}

	private void VerMembresia(int idPersona) {
		ArrayList<String[]> membresias = cons.getMembresiaVencida(idPersona);
		Iterator<String[]> it = membresias.iterator();

		while (it.hasNext()) {
			String[] membresia = it.next();
			System.out.println(
					membresia[0] + "/" + membresia[1] + "/" + membresia[2] + "/" + membresia[3] + "/" + membresia[4]);
		}
		System.out.println("Para volver, presione una tecla");
		sc.next();
		Cliente();
	}

	public void VerGrupos() {
		ArrayList<String[]> grupos = cons.getGrupos();
		Iterator<String[]> it = grupos.iterator();

		while (it.hasNext()) {
			String[] grupo = it.next();
			System.out.println(grupo[0] + "/" + grupo[1] + "/" + grupo[2] + "/" + grupo[3] + "/" + grupo[4]);
		}
		System.out.println("Para volver, presione una tecla");
		sc.next();
		Cliente();
	}
	public void VerGruposIncritos (int idPersona) {
		ArrayList<String[]> gruposInscritos = cons.getGruposInscritos(idPersona);
		Iterator<String[]> it = gruposInscritos.iterator();
		
		while (it.hasNext()) {
			String [] gruposInscrito = it.next();
			System.out.println(gruposInscrito[0] + "/" + gruposInscrito[1] + "/" + gruposInscrito[2] + "/" + gruposInscrito[3] + "/" + gruposInscrito[4]);
			
		}
		System.out.println("Para volver, presione una tecla");
		sc.next();
		Cliente();
	}

}
