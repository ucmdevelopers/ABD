package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

//Imports para pruebas en main
import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
//---
public class UsuarioMapper extends AbstractMapper<Usuario,String>{//UserKeys

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
		String str =  "passwd"+"="+ "'"+obj.getPasswd()+"'"+" where "+" nick"+" = "+"'"+obj.getId_user()+"'";
		return str;
	}
	@Override
	public String pharseInsert(Usuario obj) {
		String str = " (nick , passwd)" + " values " + " ( " + "'"+obj.getId_user()+"'" + " , " + "'"+obj.getPasswd()+"'"  + " )";
		return str;
	}
	@Override
	public String pharseDelete(String id) {
		String str ="nick"+ "="+ "'"+id+"'" ;
		return str;
	}
	
	
	
	//No se necesitan estos metodos en está clase por eso no se implementan
	@Override
	protected String getKey(Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 public static void main(String args[])
		        throws Exception
		    {
		 
		 //creamos y configuramos un objeto data source:
		 MysqlDataSource mysqlDataSource = new MysqlDataSource();
		 mysqlDataSource.setServerName("localhost");
		 mysqlDataSource.setDatabaseName("practica11");
		 mysqlDataSource.setPort(3306);
		 mysqlDataSource.setUser("root");
		 mysqlDataSource.setPassword("");
		 //establecemos la conexión con la BBDD, esto ya se hace dentro de cada una de las funciones antes listadas por eso prescindimos
		 //Connection con = mysqlDataSource .getConnection();
		
		 //creamos un usuarioMapper, pasandole un objeto DataSource
		 UsuarioMapper mapUsr = new UsuarioMapper( mysqlDataSource);
		
		 
		 //Ejemplo Insert
		 //Usuario us=new Usuario("Thor","maler12");
		// mapUsr.Insert(us);	
		 
		
		 //Ejemplo Update
		 Usuario uss=new Usuario("Thor","98756");
		 mapUsr.update(uss);
		 
		  //Ejemplos Delete
		  // mapUsr.Delete("paulos") ;
		  // mapUsr.Delete("Mark") ;
		
		    }
	

	

}
