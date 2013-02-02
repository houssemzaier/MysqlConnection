package fr.montpellier.pfe.ala;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.montpellier.pfe.ala.dao.Client;
import fr.montpellier.pfe.ala.db.Setting;

public class Main {

	public static void main(String[] args) throws SQLException {
		Setting s = Setting.getInstance();
		ArrayList<Client> myClients = s.getAllClient();
	
		for (Client client : myClients) {
			System.out.print("Client N°" + client.getIdClient());
			System.out.println("____ Name of client " + client.getNameClient());

		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		ArrayList<Client> myClientss = s.getAllClient();
		
		for (Client client : myClientss) {
			System.out.print("Client N°" + client.getIdClient());
			System.out.println("____ Name of client " + client.getNameClient());

		}
		
	}

}
