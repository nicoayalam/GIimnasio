package Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.Clase;
import Entity.Instructor;
import Entity.Persona;
import Entity.Sala;
import Entity.Vendedor;

public class Consulta {
	Conexion con;

	public Consulta() {
	}

	public ArrayList<String[]> getTotalVentas(){
		String sql = "SELECT persona.Nombre, SUM(venta.Precio) "
				+ "FROM venta, persona, vendedor "
				+ "WHERE vendedor.IdVendedor = venta.IdVendedor AND vendedor.IdPersona = persona.IdPersona GROUP BY persona.Nombre";
		Statement st;
		ResultSet rs;
		ArrayList<String[]> ventas = new ArrayList<String[]>();
		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String nombre = rs.getString(1);
				String total = rs.getString(2);
				String[] res = {nombre, total};
				ventas.add(res);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ventas;
		
	}
	public ArrayList<String[]> getVentasPorVendedor(int idVendedor){
		String sql = "SELECT venta.IdGrupo, venta.IdMembresia, persona.Nombre, venta.Precio "
				+ "FROM venta, persona, vendedor "
				+ "WHERE vendedor.IdVendedor = venta.IdVendedor AND vendedor.IdPersona = persona.IdPersona AND vendedor.IdVendedor = "+idVendedor;
		Statement st;
		ResultSet rs;
		ArrayList<String[]> ventas = new ArrayList<String[]>();
		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String idGrupo = rs.getString(1);
				String idMembresia = rs.getString(2);
				String nombre = rs.getString(3);
				String precio = rs.getString(4);
				String[] res = {idGrupo, idMembresia, nombre, precio};
				ventas.add(res);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ventas;
		
	}

	public int getUltimoIDMembresia() {
		String sql = "SELECT IdMembresia " + "FROM membresia " + "ORDER BY idMembresia DESC LIMIT 1";
		Statement st;
		ResultSet rs;
		int idMembresia = 0;

		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			rs.next();
			idMembresia = rs.getInt(1);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return idMembresia;
	}

	public void realizarVentaStandard(int idPersona) {
		String sql = "INSERT INTO membresia(idMembresia, idPersona,Tipo, FechaInicio, FechaFin)" + " VALUES (NULL, "
				+ idPersona + ", 'Standard', NOW(), DATE_ADD(CURDATE(), INTERVAL 30 DAY))";
		Statement st;

		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			st.executeQuery(sql);
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void insertarVenta(int idGrupo, int idMembresia, int idVendedor, double precio) {
		String sql = "INSERT INTO venta(idGrupo, idMembresia, idVendedor, precio) " + "VALUES (" + idGrupo + ", "
				+ idMembresia + ", " + idVendedor + ", " + precio + ")";
		Statement st;

		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			st.executeQuery(sql);
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void realizarVentaPremium(int idPersona) {
		String sql = "INSERT INTO membresia(idMembresia, idPersona,Tipo, FechaInicio, FechaFin)" + " VALUES (NULL, "
				+ idPersona + ", 'Premium', NOW(), DATE_ADD(CURDATE(), INTERVAL 90 DAY))";
		Statement st;

		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			st.executeQuery(sql);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public ArrayList<Sala> getSala() {
		String sql = "SELECT *\r\n" + "FROM sala";
		Statement st;
		ResultSet rs;
		ArrayList<Sala> salas = new ArrayList<Sala>();

		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				int idSala = rs.getInt(1);
				String nombreSala = rs.getString(2);
				String ubicacion = rs.getString(3);
				Sala s = new Sala(idSala, nombreSala, ubicacion);
				salas.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return salas;
	}

	public ArrayList<Persona> getPersona() {

		String sql = "SELECT *\r\n" + "FROM persona";
		Statement st;
		ResultSet rs;
		ArrayList<Persona> personas = new ArrayList<Persona>();

		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				int idPersona = rs.getInt(1);
				String nombre = rs.getString(2);
				String direccion = rs.getString(3);
				int telefono = rs.getInt(4);
				int CI = rs.getInt(5);
				Persona p = new Persona(idPersona, nombre, direccion, telefono, CI);

				personas.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return personas;

	}

	public ArrayList<Instructor> getInstructor() {
		String sql = "SELECT *\r\n" + "FROM instructor, persona\r\n" + "WHERE instructor.IdPersona = persona.IdPersona";
		Statement st;
		ResultSet rs;
		ArrayList<Instructor> instructores = new ArrayList<Instructor>();
		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idInstructor = rs.getInt(1);
				int idPersona = rs.getInt(2);
				int idReferencia = rs.getInt(3);
				String nombre = rs.getString(5);
				String direccion = rs.getString(6);
				int telefono = rs.getInt(7);
				int CI = rs.getInt(8);
				Instructor i = new Instructor(idInstructor, idPersona, idReferencia, direccion, telefono, nombre, CI);
				instructores.add(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return instructores;
	}

	public ArrayList<Clase> getClase() {
		String sql = "SELECT *\r\n" + "FROM clase, sala\r\n" + "WHERE clase.IdSala = sala.IdSala";
		Statement st;
		ResultSet rs;
		ArrayList<Clase> clases = new ArrayList<Clase>();
		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idClase = rs.getInt(1);
				int idSala = rs.getInt(2);
				String Nombre = rs.getString(4);
				String Ubicacion = rs.getString(5);
				Clase c = new Clase(idClase, idSala, Nombre, Ubicacion);
				clases.add(c);
			}
		} catch (Exception e) {

		}
		return clases;

	}

	public ArrayList<Vendedor> getVendedor() {
		String sql = "SELECT *\r\n" + "FROM vendedor, persona\r\n" + "WHERE persona.IdPersona = vendedor.IdPersona";
		Statement st;
		ResultSet rs;
		ArrayList<Vendedor> Vendedores = new ArrayList<Vendedor>();

		try {

			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idVendedor = rs.getInt(1);
				int idPersona = rs.getInt(2);
				double descuento = rs.getDouble(3);
				String Nombre = rs.getString(5);
				String Direccion = rs.getString(6);
				int telefono = rs.getInt(7);
				int CI = rs.getInt(7);
				Vendedor v = new Vendedor(idVendedor, idPersona, descuento, Nombre, Direccion, telefono, CI);
				Vendedores.add(v);
			}
		} catch (Exception e) {

		}
		return Vendedores;

	}

	public void insertPersona(String nombre, String direccion, int telefono, int CI) {
		String sql = "INSERT \r\n" + "INTO persona\r\n" + "VALUES (NULL, '" + nombre + "','" + direccion + "', "
				+ telefono + ", " + CI + ")";
		try {
			Statement st;
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			st.executeQuery(sql);
			con.commit();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Instructor insertInstructor(int idPersona, int idReferencia) {

		String sql2 = "INSERT  \r\n" + "INTO instructor\r\n" + "VALUES (NULL, '" + idPersona + "', '" + idReferencia
				+ "')";
		Instructor i = new Instructor(0, 0, 0, "", 0, "", 0);
		try {
			Statement st2;
			Connection con = this.con.getInstance().getConnection();
			st2 = con.createStatement();
			st2.executeQuery(sql2);
			con.commit();
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		String sql = "SELECT Nombre, Direccion, telefono, persona.`C.I`, instructor.IdInstructor  \r\n"
				+ "FROM persona, instructor\r\n"
				+ "WHERE persona.IdPersona = instructor.IdPersona AND instructor.IdPersona = " + idPersona;
		Statement st;
		ResultSet rs;
		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				;
				String nombre = rs.getString(1);
				String direccion = rs.getString(2);
				int telefono = rs.getInt(3);
				int CI = rs.getInt(4);
				int idInstructor = rs.getInt(5);
				i = new Instructor(idInstructor, idPersona, idReferencia, direccion, telefono, nombre, CI);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	public ArrayList<String[]> getMembresiaVencida(int idPersona) {
		String sql = "SELECT membresia.IdMembresia AS 'Numero Membresia', persona.Nombre, membresia.Tipo, membresia.FechaInicio, membresia.FechaFin"
				+ " FROM membresia, persona" + " WHERE membresia.IdPersona = persona.IdPersona AND persona.IdPersona = "
				+ idPersona + " AND FechaFin>=NOW()";

		Statement st;
		ResultSet rs;
		ArrayList<String[]> membresias = new ArrayList<String[]>();
		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String numeroMembresia = rs.getString(1);
				String nombre = rs.getString(2);
				String tipo = rs.getString(3);
				String fechaInicio = rs.getString(4);
				String fechaFin = rs.getString(5);
				String[] res = { numeroMembresia, nombre, tipo, fechaInicio, fechaFin };
				membresias.add(res);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return membresias;
	}

	public ArrayList<String[]> getGrupos() {
		ArrayList<String[]> grupos = new ArrayList<String[]>();
		String sql = "SELECT grupo.IdGrupo, persona.Nombre AS 'Instructor', grupo.Horario, sala.Nombre AS 'Nombre Sala', sala.Ubicacion "
				+ "FROM instructor, persona, grupo, sala, clase "
				+ "WHERE instructor.IdPersona = persona.IdPersona AND instructor.IdInstructor = grupo.IdInstructor AND grupo.IdClase= clase.IdClase AND clase.IdSala = sala.IdSala";
		Statement st;
		ResultSet rs;
		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				;
				String idGrupo = rs.getString(1);
				String nombreInstructor = rs.getString(2);
				String horario = rs.getString(3);
				String nombreSala = rs.getString(4);
				String ubicacion = rs.getString(5);
				String[] res = { idGrupo, nombreInstructor, horario, nombreSala, ubicacion };
				grupos.add(res);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return grupos;
	}

	public ArrayList<String[]> getGruposInscritos(int idPersona) {
		String sql = "SELECT grupo.IdGrupo, ins.Nombre, grupo.Horario, sala.Nombre AS 'Nombre Sala', sala.Ubicacion\r\n" + 
				"FROM instructor, persona cli, persona ins, grupo, sala, clase, personagrupo\r\n" + 
				"WHERE instructor.IdPersona = ins.IdPersona AND personagrupo.idGrupo = grupo.IdGrupo AND personagrupo.idPersona= cli.IdPersona AND instructor.IdInstructor = grupo.IdInstructor AND grupo.IdClase= clase.IdClase AND clase.IdSala = sala.IdSala AND cli.IdPersona ="
				+ idPersona;
		Statement st;
		ResultSet rs;
		ArrayList<String[]> gruposInscritos = new ArrayList<String[]>();
		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String idGrupo = rs.getString(1);
				String Nombre = rs.getString(2);
				String Horario = rs.getString(3);
				String NombreSala = rs.getString(4);
				String Ubicacion = rs.getString(5);
				String[] res = { idGrupo, Nombre, Horario, NombreSala, Ubicacion };
				gruposInscritos.add(res);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return gruposInscritos;
	}

	public ArrayList<String[]> getMembresiaActiva(int idPersona) {
		String sql = "SELECT membresia.IdMembresia AS 'Numero Membresia', persona.Nombre, membresia.Tipo, membresia.FechaInicio, membresia.FechaFin"
				+ " FROM membresia, persona" + " WHERE membresia.IdPersona = persona.IdPersona AND persona.IdPersona = "
				+ idPersona + " AND FechaFin<NOW()";

		Statement st;
		ResultSet rs;
		ArrayList<String[]> membresias = new ArrayList<String[]>();
		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String numeroMembresia = rs.getString(1);
				String nombre = rs.getString(2);
				String tipo = rs.getString(3);
				String fechaInicio = rs.getString(4);
				String fechaFin = rs.getString(5);
				String[] res = { numeroMembresia, nombre, tipo, fechaInicio, fechaFin };
				membresias.add(res);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return membresias;
	}

	public ArrayList<String[]> getGrupoInstructor(int idInstructor) {
		String sql = "SELECT grupo.IdGrupo , Horario, Ubicacion, sala.Nombre\r\n"
				+ "FROM instructor, grupo, clase, sala\r\n"
				+ "WHERE instructor.IdInstructor = grupo.IdInstructor AND grupo.IdClase = clase.IdClase AND sala.IdSala = clase.IdSala AND instructor.IdInstructor ="
				+ idInstructor;

		Statement st;
		ResultSet rs;
		ArrayList<String[]> ClasesInstructos = new ArrayList<String[]>();

		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String idGrupo = rs.getString(1);
				String horario = rs.getString(2);
				String ubicacion = rs.getString(3);
				String nombre = rs.getString(4);
				String[] res = { idGrupo, horario, ubicacion, nombre };
				ClasesInstructos.add(res);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ClasesInstructos;
	}

	public ArrayList<String[]> getInformacionReferente(int idInstructor) {
		String sql = "SELECT Nombre, Direccion, telefono, persona.`C.I`\r\n" + "FROM instructor, persona\r\n"
				+ "WHERE persona.IdPersona = instructor.IdReferencia AND instructor.IdInstructor=" + idInstructor;

		Statement st;
		ResultSet rs;
		ArrayList<String[]> InfoReferente = new ArrayList<String[]>();

		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				String Nombre = rs.getString(1);
				String Ubicacion = rs.getString(2);
				String telefono = rs.getString(3);
				String CI = rs.getString(4);
				String[] res = { Nombre, Ubicacion, telefono, CI };
				InfoReferente.add(res);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return InfoReferente;
//Prueba
	}

}
