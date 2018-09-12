package Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.Instructor;
import Entity.Persona;
import Entity.Sala;

public class Consulta {
	Conexion con;
	public Consulta()
	{}
	
	public ArrayList<Sala> getSala()
	{
		String sql = "SELECT *\r\n" + 
				"FROM sala";
		Statement st;
		ResultSet rs;
		ArrayList<Sala> salas = new ArrayList<Sala>();
		
		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				int idSala = rs.getInt(1);
				String nombreSala = rs.getString(2);
				String ubicacion = rs.getString(3);
				Sala s = new Sala(idSala, nombreSala, ubicacion);
				salas.add(s);				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return salas;
	}
	
	public ArrayList<Persona> getPersona(){
		
		String sql = "SELECT *\r\n" + 
				"FROM persona";
		Statement st;
		ResultSet rs;
		ArrayList<Persona> personas = new ArrayList<Persona> ();
		
		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				int idPersona = rs.getInt(1);
				String nombre = rs.getString(2);
				String direccion = rs.getString(3);
				int telefono = rs.getInt(4);
				int CI = rs.getInt(5);
				Persona p = new Persona(idPersona, nombre, direccion, telefono, CI);
				
				personas.add(p);				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return personas;
			
			
		}
	
	public ArrayList<Instructor> getInstructor()
	{
		String sql = "SELECT *\r\n" + 
				"FROM instructor, persona\r\n" + 
				"WHERE instructor.IdPersona = persona.IdPersona";
		Statement st;
		ResultSet rs;
		ArrayList<Instructor> instructores = new ArrayList<Instructor>();
		try {
			Connection con = this.con.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next())
			{
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
		
	}
	
	

