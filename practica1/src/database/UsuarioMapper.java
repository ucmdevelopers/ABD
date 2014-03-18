package database;

//import java.math.BigInteger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.UserKeys;
import model.Usuario;





//-----para pruebas main
import java.sql.*;
//---
public class UsuarioMapper extends AbstractMapper<Usuario,UserKeys>{

	private Usuario usr; 

	public UsuarioMapper(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}
	public UsuarioMapper(DataSource dataSource, Usuario _usr) {
		super(dataSource);
		this.usr= _usr;
	}


	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return model.Constants.USER_TABLE ;
	}

	@SuppressWarnings("null")
	@Override
	protected Usuario buildObject(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		 Usuario result = null;
		 result.setId_user(rs.getString("id_user"));
		 result.setPasswd(rs.getString("passwd"));
		return result;
	}

	@Override
	protected Object[] serializeObject(Usuario object) {
		// TODO Auto-generated method stub
		
		return new Object[] {object.getId_user(),object.getPasswd()};
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		 	return new String[]{"nick", "passwd", "fecha_nac", "img"};
	}

	
	@Override
	public String pharseUpdate(Usuario obj) {
		String str =  "passwd"+"="+obj.getPasswd()+" where "+" nick"+" = "+obj.getId_user();
		return str;
	}
	@Override
	public String pharseInsert(Usuario obj) {
		String str = "(nick , passwd)" + " value " + " ( " +obj.getId_user() + " , " + obj.getPasswd()  + " )";
		return str;
	}
	@Override
	public String pharseDelete(UserKeys id) {
		String str ="nick "+ "="+id ;
		return str;
	}
	
	
	
	//No se necesitan estos metodos en está clase por eso no se implementan
	@Override
	protected UserKeys getKey(Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected Object[] serializeKey(UserKeys key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 public static void main(String args[])
		        throws Exception
		    {
		//The DataSource interface as an alternative to the DriverManager for establishing a connection with a data source
		 		//Accessing driver
		 		Class.forName("com.mysql.jdbc.Driver");
		 		//creating a variable for the connection
		 		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica11","root","");
		 		//Connection con = DataSource.getConnection("jdbc:mysql://localhost:3306/practica11","root","");
		 		
		 		//DataSource data= 
		 		//UsuarioMapper s= new UsuarioMapper(); 
		 		/*PreparedStatement statement = con.prepareStatement("select * from usuarios");
		 		ResultSet result = statement.executeQuery();
		 		while(result.next())
		 		{
		 			System.out.println(result.getString(1)+""+result.getString(2));
		 		}*/
		    
		    
		    
		    
		    }
	

	

}
