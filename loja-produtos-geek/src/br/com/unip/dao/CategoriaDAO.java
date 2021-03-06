package br.com.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unip.modelo.Categoria;
import br.com.unip.modelo.Produto;


public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(Categoria categoria) throws SQLException {
		try (PreparedStatement pstm = connection.prepareStatement(
				"INSERT INTO CATEGORIA(CATEGORIA)VALUES(?)",
				Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, categoria.getCategoria());
						
			pstm.execute();
			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					categoria.setIdCat(rst.getInt(1));
				}
			}
		}
	}

	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		try (PreparedStatement pstm = connection.prepareStatement("SELECT * FROM CATEGORIA")) {
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}

	public void atualizar(Categoria categoria) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("UPDATE CATEGORIA C SET C.CATEGORIA = ?")){
			pstm.setString(1, categoria.getCategoria());
			pstm.execute();
		}

	}

	public void remover(Categoria categoria) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM CATEGORIA WHERE ID = ?")) {
			pstm.setInt(1, categoria.getIdCat());
			pstm.execute();
		}

	}

}
