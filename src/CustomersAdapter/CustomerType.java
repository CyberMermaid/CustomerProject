package CustomersAdapter;

import java.sql.*;
import General.*;

public class CustomerType implements IAdapter {

	public String[] fetchData() {
		String[] values = null;

		// Result set get the result of the SQL query
		String query = "select * from customer_type;";
		String[] name = { "title" };
		values = Database.fetchAnyData(query, name);
		return values;
	}

	@Override
	public int getCount(ResultSet r) {
		return 0;
	}

	@Override
	public boolean deletebyID(int ID) {
		String query = "Delete from contustomer_type where ID = ?;";
		return Database.deleteAnyRecord(query, ID);
	}

	@Override
	public boolean addRecord(String[] types, String[] value) {
		String query = "INSERT INTO contacts.customer_type (`Title`) VALUES (?)";
		return Database.addAnyRecord(query, types, value);
	}
}
