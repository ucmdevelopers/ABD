package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;






import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;















public abstract class AbstractMapper <T,K> {
	protected DataSource ds;
	protected abstract String getTableName();
	protected abstract String[] getColumnNames();
	protected abstract T buildObject (ResultSet rs) throws SQLException;

	protected abstract Object[] serializeKey(K key);
	protected abstract Object[] serializeObject(T object);
	protected abstract K getKey(T obj);
	public AbstractMapper(DataSource dataSource){
		this.ds=dataSource;
	}
	
	public DataSource getDs() {
		return ds;
	}
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	public T findById(K id){
		/*QueryConditions[] conditions= getQueryConditionsFromKey(id);
		List<T> results = findByConditions(conditions);
		if(results.isEmpty()){
			return null;
		}
		else{
			return results.get(0);
		}*/
		Connection con =null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		T result=null;
		try{
			con= ds.getConnection();
			QueryConditions[] conditions= getQueryConditionsFromKey(id);
			String whereConditions=generateWhereConditions(conditions);
			String sql="SELECT"+ getColumnNames()+ whereConditions;
			pst = con.prepareStatement(sql);
			for (int i = 0; i < conditions.length; i++) {
				pst.setObject(i+1,conditions[i].getValor());
			}
			rs=pst.executeQuery();
			if(rs!=null){
				result = buildObject(rs);
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
				if(con!=null) con.close();
				
			}catch (Exception e){}
		}
		
		
		return result;
	}
	private String generateWhereConditions(QueryConditions[] conditions) {
		// TODO Auto-generated method stub
		String result="Where ";
		String[] cadConditions=new String[conditions.length];
		for (int i = 0; i < conditions.length; i++) {
			cadConditions[i]=conditions[i].toString();
		}
		result+=StringUtils.join(cadConditions, " and ");
		return result;
	}
	private List<T> findByConditions(QueryConditions[] conditions) {
		// TODO Auto-generated method stub
		List<T> result= new LinkedList<T>();
		for (int i = 0; i < conditions.length; i++) {
			
		}
		return null;
	}
	private QueryConditions[] getQueryConditionsFromKey(K id){
		String[] keyColumnNames= getColumnNames();
		Object[] keyValues= serializeKey(id);
		QueryConditions[] conditions= new QueryConditions[keyColumnNames.length];
		for (int i = 0; i < conditions.length; i++) {
			conditions[i]= new QueryConditions(keyColumnNames[i], Operator.EQ, keyValues[i]);
		}
		return conditions;
	}
	
}
