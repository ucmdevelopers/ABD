package model;

//import java.math.BigInteger;
//import java.sql.Date;Depricated!!! casi entera

public class Usuario {
	private String id_user;
	private String passwd;
	
	
public Usuario(){
		this.id_user=null;
		this.passwd=null;
		
	}
	public Usuario(String id_user, String passwd) {
		super();
		this.id_user = id_user;
		this.passwd = passwd;
		
	}
	
	
	
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
