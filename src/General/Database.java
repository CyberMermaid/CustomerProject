package General;
import java.sql.*;

public class Database {
	 //Define a member called Connections
	static String url = "jdbc:mysql://localhost:3306/contacts?useSSL=false";
	static String username = "root"; 
	static String pwd = "Chall3ng3Acc3pt3d";
	public static Connection getConnection() {
		Connection conn= null;
		try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,username, pwd);
		} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static String[] fetchAnyData(String query, String [] columnName) {
		Statement s;
		String[] values = null;
		try {
			s = getConnection().createStatement();

			// Result set get the result of the SQL query
			ResultSet result = s.executeQuery(query);
			int rowsize = 0;
			if (result.last()) {
				rowsize = result.getRow();
				result.beforeFirst();
			}
			values = new String[rowsize];
			int i = 0;
			while (result.next()) { // retrieve data
				String data = "";
				for(int j=0;j<columnName.length; j++)
					data += result.getString(columnName[j])+" ";
				values[i++] = data;//
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return values;

	}
	
	public static boolean deleteAnyRecord(String query, int ID)
	{
		PreparedStatement s; 
		try {
			s= getConnection().prepareStatement(query);
			s.setInt(1, ID);
			return s.executeUpdate()>0?true:false; 
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean addAnyRecord (String query,String [] Types, String [] values) {
		PreparedStatement s; 
		try {
			s= getConnection().prepareStatement(query);
			for(int i=1 ;i<=values.length;i++)
			{
				if(Types[i-1]=="String")
					s.setString(i, values[i-1]);
				else if(Types[i-1]=="Integer")
					s.setInt(i, Integer.parseInt(values[i-1]));
			}
		
			return s.executeUpdate()>0?true:false; 
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		
		return false;
	}
}
