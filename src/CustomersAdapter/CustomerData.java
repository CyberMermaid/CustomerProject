package CustomersAdapter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import General.Database;

public class CustomerData implements IAdapter {

	public String[] fetchData() {
		String[] values = null;

		// Result set get the result of the SQL query
		String query = "select * from customer_data;";
		String[] name = { "ID", "f_name", "l_name" };
		values = Database.fetchAnyData(query, name);
		return values;
	}

	@Override
	public int getCount(ResultSet r) {
		return 0;
	}

	@Override
	public boolean deletebyID(int ID) {
		String query = "Delete from customer_data where ID = ?;";
		return Database.deleteAnyRecord(query, ID);
	}

	@Override
	public boolean addRecord(String[] types, String[] oneRowValues) {
		String query = "INSERT INTO contacts.customer_data (`f_name`, `l_name`,`customer_type_ID`,`gender`,`birthday`  ) VALUES (?, ?, ?);";
		return Database.addAnyRecord(query, types, oneRowValues);
	}
}
