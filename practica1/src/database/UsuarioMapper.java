package database;

import java.sql.PreparedStatement;
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
		 Usuario result = new Usuario();
		 result.setId_user(rs.getString("nick"));
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
	protected String pharseUpdate() {
		//column1=value1,column2=value2,...+WHERE some_column=some_value solo rellenamos por ahora nick y passwd, aunque sea nuestra clave el nick, el usuario no lo podra modificar asi que lo machacamos, volvemos a escribirlo.
		String colNam[] = getColumnNames();
		String str = colNam[0]+"= ? ,"+colNam[1]+"= ?  where "+colNam[0]+"= ? ";
		
		return str;
	}

	@Override
	protected String pharseInsert() {
		String colNam[] = getColumnNames();//","+colNam[2]+","+colNam[3]
		String str = " ("+colNam[0]+","+colNam[1]+")"+ " values " + " ( ?  , ?  ) ";//" ( " + " ? ," + " ? ,"  +" ? ,"  +" ?  "  + " )", no se puede insertar si no se rellena todos los ?
		return str;
	}
	@Override
	protected String[] getKeyColumnNames() {
		// TODO Auto-generated method stub
		String[] keyCol={"nick"};
		return keyCol;
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
		return new Object[] { key };
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
		// Usuario us=new Usuario("Magnus","stoisto");//el usuario ya hecho que le pasa el controller con los datos a la ultima
		// mapUsr.Insert(us);	
		 
		
		 //Ejemplo Update
		 Usuario uss=new Usuario("Mark","GoreGora");
		 mapUsr.update(uss);
		 
		  //Ejemplos Delete
		  // mapUsr.Delete("Thor") ;
		  // mapUsr.Delete("Mark") ;
		 
		 //Ejemplos select
		// Usuario sr = new Usuario();
		// sr = mapUsr.findById("Mark");
		
		 //System.out.println(mapUsr.pharseInsert());
		    }

	 
	 @Override
	protected void fill(PreparedStatement pst, Usuario obj,boolean ins) {
		//el objeto que ya recibe ha de ser con todo actualizado, si es insert o modifica los datos han de ser los ultimos, se basa en "machacar" todo lo anterior
		try {
			pst.setString(1, obj.getId_user());//? de nick
			pst.setString(2,obj.getPasswd());// ? de passwd
			if(!ins){//si es update necesitamos rellenar la condicion where con el nick .
				pst.setString(3, obj.getId_user());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	

	
	

	

}
