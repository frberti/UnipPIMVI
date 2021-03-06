package br.com.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unip.modelo.Categoria;
import br.com.unip.modelo.Endereco;


public class EnderecoDAO {

	private Connection connection;

	public EnderecoDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(Endereco endereco) throws SQLException {
		try (PreparedStatement pstm = connection.prepareStatement(
				"INSERT INTO ENDERECO(LOGRADOURO, RUA, NUMERO, BAIRRO, CIDADE, CEP)"
				+ "VALUES(?,?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, endereco.getLogradouro());
			pstm.setString(2, endereco.getRua());
			pstm.setInt(3, endereco.getNumero());
			pstm.setString(4, endereco.getBairro());
			pstm.setString(5, endereco.getCidade());
			pstm.setInt(6, endereco.getCep());
			
						
			pstm.execute();
			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					endereco.setEnderecoId(rst.getInt(1));
				}
			}
		}
	}

	public List<Endereco> listar() throws SQLException {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		try (PreparedStatement pstm = connection.prepareStatement("SELECT * FROM ENDERECO")) {
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Endereco endereco = new Endereco(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4), 
							rst.getString(5), rst.getString(6), rst.getInt(7));
					enderecos.add(endereco);
				}
			}
		}
		return enderecos;
	}

	public void atualizar(Endereco endereco) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("UPDATE ENDERECO E SET E.LOGRADOURO = ?, E.RUA = ?, E.NUMERO = ?, "
				+ "E.BAIRRO = ?, E.CIDADE = ?, E.CEP = ?")){
			pstm.setString(1, endereco.getLogradouro());
			pstm.setString(2, endereco.getRua());
			pstm.setInt(3, endereco.getNumero());
			pstm.setString(4, endereco.getBairro());
			pstm.setString(5, endereco.getCidade());
			pstm.setInt(6, endereco.getCep());
			pstm.execute();
		}

	}

	public void remover(Endereco endereco) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM ENDERECO WHERE ID = ?")) {
			pstm.setInt(1, endereco.getEnderecoId());
			pstm.execute();
		}

	}

}
