package CustomersAdapter;

import java.sql.*;
import General.*;

public class ContactType implements IAdapter {

	public String[] fetchData() {
		String[] values = null;

		// Result set get the result of the SQL query
		String query = "select * from contact_type;";
		String[] name = { "ID", "title" };
		values = Database.fetchAnyData(query, name);
		return values;
	}

	@Override
	public int getCount(ResultSet r) {
		int rowsize = 0;
		try {
			if (r.last()) {
				rowsize = r.getRow();
				r.beforeFirst();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsize;
	}

	@Override
	public boolean deletebyID(int ID) {
		String query = "Delete from contact_type where ID = ?;";
		return Database.deleteAnyRecord(query, ID);
	}

	@Override
	public boolean addRecord(String[] types, String [] values) {
		String query = "INSERT INTO contacts.contact_type (`Title`) VALUES (?)";
		return 	Database.addAnyRecord(query, types, values);

	}

}
