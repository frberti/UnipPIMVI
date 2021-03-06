package br.com.unip.pim_vi.modelo;

public class Produto {

	private Integer codigoDeBarras;
	private String nome;
	private String categoria;
	private String fabricante;
	private Integer quantidade;
	private Double preco;
	
	public Produto() {
		
	}

	public Produto(Integer codigoDeBarras, String nome, String categoria, String fabricante, Integer quantidade,
			Double preco) {
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.categoria = categoria;
		this.fabricante = fabricante;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Integer getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(Integer codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
