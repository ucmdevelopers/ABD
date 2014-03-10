package database;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.UserKeys;
import model.Usuario;

public class UsuarioMapper extends AbstractMapper<Usuario,UserKeys>{

	

	public UsuarioMapper(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
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
		 result.setId_user(new BigInteger(Integer.valueOf(rs.getInt("id_user")).toString()));
		 result.setNombre(rs.getString("nombre"));
		 result.setApell0(rs.getString("apellido0"));
		 result.setApell0(rs.getString("apellido1"));
		 result.setSexo( rs.getString("sexo").charAt(0));
		 result.setNac(rs.getDate("fecha_nacimiento"));
		 result.setLog(rs.getString("log"));
		 result.setPass(rs.getString("pass"));
		return result;
	}

	
	

	@Override
	protected Object[] serializeObject(Usuario object) {
		// TODO Auto-generated method stub
		
		return new Object[] {object.getId_user(),object.getNombre(),object.getApell0(),object.getSexo(),object.getNac(),object.getLog(),object.getPass()};
	}

	

	@Override
	protected Object[] serializeKey(UserKeys key) {
		// TODO Auto-generated method stub
		
		return new Object[]{key.getKey()};
	}

	@Override
	protected UserKeys getKey(Usuario obj) {
		// TODO Auto-generated method stub
		return new UserKeys(obj.getId_user());
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		 	return new String[]{"id_user", "nombre", "apellido0", "apellido1", "sexo", "fecha_nacimiento", "log", "pass"};
	}

	

}
