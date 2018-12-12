import java.sql.*;

import CustomersAdapter.*;

public class Test {

	public static void main(String[] args) {
		ContactType ct = new ContactType();
		String data[] = ct.fetchData();
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	   boolean x;// = ct.deletebyID(1);
		//System.out.print("Delete status:" + x);
	   
		String t[] = {"String"};
		String v[] = {"anyTitle"};
		
		x = ct.addRecord(t,v);
		
		System.out.print("Insert status: Test" + x);
	}
}
