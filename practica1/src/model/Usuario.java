package model;

import java.math.BigInteger;
import java.sql.Date;

public abstract class Usuario {
	private BigInteger id_user;
	private String nombre;
	private String apell0;
	private String apell1;
	private char sexo;
	private Date nac;
	private String log;
	private String pass;
	public Usuario(){
		this.id_user=null;
		this.nombre=null;
		this.apell0=null;
		this.apell1=null;
		this.sexo='U';
		this.nac=null;
		this.log=null;
		this.pass=null;
	}
	public Usuario(BigInteger id_user, String nombre, String apell0,
			String apell1, char sexo, Date nac, String log, String pass) {
		super();
		this.id_user = id_user;
		this.nombre = nombre;
		this.apell0 = apell0;
		this.apell1 = apell1;
		this.sexo = sexo;
		this.nac = nac;
		this.log = log;
		this.pass = pass;
	}
	public BigInteger getId_user() {
		return id_user;
	}
	public void setId_user(BigInteger id_user) {
		this.id_user = id_user;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApell0() {
		return apell0;
	}
	public void setApell0(String apell0) {
		this.apell0 = apell0;
	}
	public String getApell1() {
		return apell1;
	}
	public void setApell1(String apell1) {
		this.apell1 = apell1;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public Date getNac() {
		return nac;
	}
	public void setNac(Date nac) {
		this.nac = nac;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
