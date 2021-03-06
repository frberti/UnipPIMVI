package br.com.unip.pim_vi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unip.pim_vi.modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(Produto produto) throws SQLException {
		try (PreparedStatement pstm = connection.prepareStatement(
				"INSERT INTO PRODUTO(NOME, CATEGORIA, FABRICANTE, QUANTIDADE, PRECO)VALUES(?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getCategoria());
			pstm.setString(3, produto.getFabricante());
			pstm.setInt(4, produto.getQuantidade());
			pstm.setDouble(5, produto.getPreco());
			pstm.execute();
			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setCodigoDeBarras(rst.getInt(1));
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
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
							rst.getInt(5), rst.getDouble(6));
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}

	public void atualizar(Produto produto) {

	}

	public void remover(Produto produto) {

	}

}
