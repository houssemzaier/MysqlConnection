package fr.montpellier.pfe.ala.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.montpellier.pfe.ala.dao.Client;

public class Setting {

	private static final String USERNAME = "houssem";
	private static final String PASSWORDS = "a";
	private static final String DATABASENAME = "mydatabase";

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	List<Client> allClients=null;
	private static Setting _me=null;
	public static Setting getInstance() throws SQLException{
		if(_me==null){
			_me=new Setting();
		}
		return _me;
	}
	
	private Setting() throws SQLException {
		// Class.forName("com.mysql.jdbc.Driver") methode pour java 5
		try {
			// methode I
			// con=DriverManager.getConnection("jdbc:mysql://localhost/mydatabase?"
			// +
			// "user=houssem&password=a");
			// methode II
			con = DriverManager.getConnection("jdbc:mysql:///" + DATABASENAME,
					USERNAME, PASSWORDS);
			System.out.println("connection is ON");
			// define methode scrollable mysql & updatable
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

		} catch (SQLException e) {
			System.err.println("Problem of setting connection ON :"+e);
		}  
	}

	public ArrayList<Client> getAllClient() throws SQLException {
		allClients=new ArrayList<Client>();
		int idClient;
		String nameClient;
		Client client;
		try {
			rs = stmt.executeQuery("SELECT * FROM "+Client.CLIENT_TABLENAME + ";");
			while (rs.next()) {
			idClient=rs.getInt(Client.CLIENT_ID);
			nameClient=rs.getString(Client.CLIENT_NAME);
			client=new  Client(idClient, nameClient);
			allClients.add(client);
			} 
			
			rs.last();
			System.out.println("the number of all rows is :" + rs.getRow());
		} catch (SQLException e) {
			System.err.println("probleme: " + e);
		}
		
		this.closeResources();
		return (ArrayList<Client>) allClients;

	}

	private void closeResources() throws SQLException {
		rs.close();
//		stmt.close();
//		con.close();

	}
}
