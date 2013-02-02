package fr.montpellier.pfe.ala.dao;

public class Client {
	public static final String CLIENT_TABLENAME = "CLIENT";
	public static final String CLIENT_ID = "ID_CLIENT";
	public static final String CLIENT_NAME = "NAME_CLIENT";

	private int idClient;
	private String nameClient;

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public Client() {
	}

	public Client(int idClient, String nameClient) {
		this.idClient = idClient;
		this.nameClient = nameClient;
	}

}
