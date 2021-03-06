package br.com.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.unip.modelo.Produto;


public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(Produto produto) throws SQLException {
		try (PreparedStatement pstm = connection.prepareStatement(
				"INSERT INTO PRODUTO(NOMEPRODUTO, FABRICANTE, QUANTIDADE, PRECO, PLATAFORMA, "
				+ "GARANTIA, IDCATEGORIA)VALUES(?,?,?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, produto.getNomeProduto());
			pstm.setString(2, produto.getFabricante());
			pstm.setInt(3, produto.getQuantidade());
			pstm.setBigDecimal(4, produto.getPreco());
			pstm.setString(5, produto.getPlataforma());
			pstm.setString(6, produto.getGarantia());
			pstm.setInt(7, produto.getIdCategoria());
			
			pstm.execute();
			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setCodigoBarras(rst.getInt(1));
				}
			}
		}
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		try (PreparedStatement pstm = connection.prepareStatement("SELECT * FROM PRODUTO")) {
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), 
							rst.getInt(3), rst.getString(4), rst.getInt(5), rst.getBigDecimal(6), 
							rst.getString(7), rst.getString(8));
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}

	public void atualizar(Produto produto) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("UPDATE PRODUTO P SET P.NOMEPRODUTO = ?, P.FABRICANTE = ?, "
				+ "P.QUANTIDADE = ?, P.PRECO = ?, P.PLATAFORMA = ?, P.GARANTIA = ?")){
			pstm.setString(1, produto.getNomeProduto());
			pstm.setString(2, produto.getFabricante());
			pstm.setInt(3, produto.getQuantidade());
			pstm.setBigDecimal(4, produto.getPreco());
			pstm.setString(5, produto.getPlataforma());
			pstm.setString(6, produto.getGarantia());
			pstm.execute();
		}

	}

	public void remover(Produto produto) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?")) {
			pstm.setInt(1, produto.getCodigoBarras());
			pstm.execute();
		}

	}

}
