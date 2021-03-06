package br.com.unip.modelo;

import java.math.BigDecimal;

public class Produto {

	private int codigoBarras;
	private String nomeProduto;
	private int idCategoria;
	private String fabricante;
	private int quantidade;
	private BigDecimal preco;
	private String plataforma;
	private String garantia;
	
	
	
	public Produto(int codigoBarras, String nomeProduto, int idCategoria, String fabricante, int quantidade,
			BigDecimal preco, String plataforma, String garantia) {
		super();
		this.codigoBarras = codigoBarras;
		this.nomeProduto = nomeProduto;
		this.idCategoria = idCategoria;
		this.fabricante = fabricante;
		this.quantidade = quantidade;
		this.preco = preco;
		this.plataforma = plataforma;
		this.garantia = garantia;
	}

	public Integer getCodigoBarras() {
		return codigoBarras;
	}
	
	public void setCodigoBarras(Integer codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public int getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public String getFabricante() {
		return this.fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	public String getGarantia() {
		return garantia;
	}
	
	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	@Override
	public String toString() {
		return "Produto [codigoBarras=" + codigoBarras + ", nomeProduto=" + nomeProduto + ", idCategoria=" + idCategoria
				+ ", fabricante=" + fabricante + ", quantidade=" + quantidade + ", preco=" + preco + ", plataforma="
				+ plataforma + ", garantia=" + garantia + "]";
	}
	
	
	

}
