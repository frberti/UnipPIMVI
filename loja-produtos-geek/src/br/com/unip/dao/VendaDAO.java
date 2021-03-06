package br.com.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unip.modelo.Categoria;
import br.com.unip.modelo.Venda;


public class VendaDAO {

	private Connection connection;

	public VendaDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(Venda venda) throws SQLException {
		try (PreparedStatement pstm = connection.prepareStatement(
				"INSERT INTO VENDA(idItemVenda, dataVenda, produto, quantidade, preco, totalVenda, "
				+ "idFormaPagto, idCliente)VALUES(?,?,?,?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS)) {
			pstm.setInt(1, venda.getIdItemVenda());
			pstm.setDate(2, venda.getDataVenda());
			pstm.setString(3, venda.getProduto());
			pstm.setInt(4, venda.getQuantidade());
			pstm.setBigDecimal(5, venda.getPreco());
			pstm.setBigDecimal(6, venda.getTotalVenda());
			pstm.setInt(7, venda.getIdFormaPagto());
			pstm.setInt(8, venda.getIdCliente());
			pstm.execute();
			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					venda.setIdVenda(rst.getInt(1));
				}
			}
		}
	}

	public List<Venda> listar() throws SQLException {
		List<Venda> vendas = new ArrayList<Venda>();
		try (PreparedStatement pstm = connection.prepareStatement("SELECT * FROM VENDA")) {
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Venda venda = new Venda(rst.getInt(1), rst.getInt(2), rst.getDate(3), rst.getString(4),
							rst.getInt(5), rst.getBigDecimal(6), rst.getBigDecimal(7), rst.getInt(8), rst.getInt(9));
					vendas.add(venda);
				}
			}
		}
		return vendas;
	}

	public void atualizar(Venda venda) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("UPDATE VENDA V SET V.idItemVenda = ?, V.dataVenda = ?, V.produto = ?, "
				+ "V.quantidade = ?, V.preco = ?, V.totalVenda = ?, V.idFormaPagto = ?, V.idCliente = ?")){
			pstm.setInt(1, venda.getIdItemVenda());
			pstm.setDate(2, venda.getDataVenda());
			pstm.setString(3, venda.getProduto());
			pstm.setInt(4, venda.getQuantidade());
			pstm.setBigDecimal(5, venda.getPreco());
			pstm.setBigDecimal(6, venda.getTotalVenda());
			pstm.setInt(7, venda.getIdFormaPagto());
			pstm.setInt(8, venda.getIdCliente());
			pstm.execute();
		}

	}

	public void remover(Venda venda) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM VENDA WHERE ID = ?")) {
			pstm.setInt(1, venda.getIdVenda());
			pstm.execute();
		}

	}

}
