package CustomersAdapter;

import java.sql.*;

import General.Database;

public class CustomerDataDetails {
	public String[] fetchData() {
		String[] values = null;

		// Result set get the result of the SQL query
		String query = "select * from customer_data_details;";
		String[] name = { "ID", "f_name", "l_name" };
		values = Database.fetchAnyData(query, name);
		return values;
	}
}
