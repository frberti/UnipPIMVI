package br.com.unip.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.unip.dao.ProdutoDAO;
import br.com.unip.factory.ConnectionFactory;

public class TestePrograma {
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().recuperarConexao();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(connection);
		
//		produtoDAO.cadastrar(new Produto(0, "Notebook", 1, "DELL", 1, 
//				BigDecimal.valueOf(800.00), "Plataforma", "Garantia"));
		
		System.out.println(produtoDAO.listar());
		
		
	}

}
