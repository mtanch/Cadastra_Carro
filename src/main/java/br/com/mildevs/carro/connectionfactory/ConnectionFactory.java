package br.com.mildevs.carro.connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mildevs", "postgres", "1234");
		} catch (SQLException e) {
			System.out.println("Erro ao estabelecer conexão.");
			e.printStackTrace();
			return null;
		}
	}
}
