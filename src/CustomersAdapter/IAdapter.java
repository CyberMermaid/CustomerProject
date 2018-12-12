package CustomersAdapter;
import java.sql.*;

public interface IAdapter {
	public boolean deletebyID(int ID); //Remove ID and return true if removed. Else False/0. Generalize function.
	public String[] fetchData();
	public int getCount(ResultSet r);
	public boolean addRecord (String[] types, String [] oneRowValues);
}

