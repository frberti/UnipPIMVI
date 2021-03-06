package br.com.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unip.modelo.Cliente;
import br.com.unip.modelo.Produto;


public class ClienteDAO {

	private Connection connection;

	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(Cliente cliente) throws SQLException {
		try (PreparedStatement pstm = connection.prepareStatement(
				"INSERT INTO CLIENTE(rg, cpf, nome, dataDeCadastro, idEnderecoCliente, "
				+ "telefone, email)VALUES(?,?,?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, cliente.getRg());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getNome());
			pstm.setDate(4, cliente.getDataDeCadastro());
			pstm.setInt(5, cliente.getIdEnderecoCliente());
			pstm.setString(6, cliente.getTelefone());
			pstm.setString(7, cliente.getEmail());
			
			pstm.execute();
			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					cliente.setIdCliente(rst.getInt(1));
				}
			}
		}
	}

	public List<Cliente> listar() throws SQLException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try (PreparedStatement pstm = connection.prepareStatement("SELECT * FROM CLIENTE")) {
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Cliente cliente = new Cliente(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDate(5),
							rst.getInt(6), rst.getString(7), rst.getString(8));
					clientes.add(cliente);
				}
			}
		}
		return clientes;
	}

	public void atualizar(Cliente cliente) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("UPDATE CLIENTE C SET C.rg = ?, C.cpf = ?, "
				+ "C.nome = ?, C.dataDeCadastro = ?, C.idEnderecoCliente = ?, C.telefone = ?, C.email = ?")){
			pstm.setString(1, cliente.getRg());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getNome());
			pstm.setDate(4, cliente.getDataDeCadastro());
			pstm.setInt(5, cliente.getIdEnderecoCliente());
			pstm.setString(6, cliente.getTelefone());
			pstm.setString(7, cliente.getEmail());
			pstm.execute();
		}

	}

	public void remover(Cliente cliente) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM CLIENTE WHERE ID = ?")) {
			pstm.setInt(1, cliente.getIdCliente());
			pstm.execute();
		}

	}

}
