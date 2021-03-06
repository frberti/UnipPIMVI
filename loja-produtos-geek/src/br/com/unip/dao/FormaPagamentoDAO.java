package br.com.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unip.modelo.Categoria;
import br.com.unip.modelo.FormaPagamento;


public class FormaPagamentoDAO {

	private Connection connection;

	public FormaPagamentoDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(FormaPagamento formaPagamento) throws SQLException {
		try (PreparedStatement pstm = connection.prepareStatement(
				"INSERT INTO FormaPagamento(formaPgto)VALUES(?)",
				Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, formaPagamento.getFormaPagto());
						
			pstm.execute();
			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					formaPagamento.setIdFormaPgto(rst.getInt(1));
				}
			}
		}
	}

	public List<FormaPagamento> listar() throws SQLException {
		List<FormaPagamento> formaPagamentos = new ArrayList<FormaPagamento>();
		try (PreparedStatement pstm = connection.prepareStatement("SELECT * FROM FormaPagamento")) {
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					FormaPagamento formaPagamento = new FormaPagamento(rst.getInt(1), rst.getString(2));
					formaPagamentos.add(formaPagamento);
				}
			}
		}
		return formaPagamentos;
	}

	public void atualizar(FormaPagamento formaPagamento) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("UPDATE FormaPagmento FP SET FP.formaPagamento = ?")){
			pstm.setString(1, formaPagamento.getFormaPagto());
			pstm.execute();
		}

	}

	public void remover(FormaPagamento formaPagamento) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM FormaPagamento WHERE ID = ?")) {
			pstm.setInt(1, formaPagamento.getIdFormaPgto());
			pstm.execute();
		}

	}

}
