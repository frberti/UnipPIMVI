package br.com.unip.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection connection;

	public Connection recuperarConexao() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost/loja_geek", "root", "root");
		

	}
}
