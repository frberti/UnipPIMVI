package br.com.unip.modelo;

import java.math.BigDecimal;
import java.sql.Date;

public class Venda {
	
	private int idVenda;
	private int idItemVenda;
	private Date dataVenda;
	private String produto;
	private int quantidade;
	private BigDecimal preco;
	private BigDecimal totalVenda;
	private int idFormaPagto;
	private int idCliente;
	
	
	

	public Venda(int idVenda, int idItemVenda, Date dataVenda, String produto, int quantidade, BigDecimal preco,
			BigDecimal totalVenda, int idFormaPagto, int idCliente) {
		super();
		this.idVenda = idVenda;
		this.idItemVenda = idItemVenda;
		this.dataVenda = dataVenda;
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.totalVenda = totalVenda;
		this.idFormaPagto = idFormaPagto;
		this.idCliente = idCliente;
	}

	public Integer getIdVenda() {
		return idVenda;
	}
	
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	public int getIdItemVenda() {
		return idItemVenda;
	}
	
	public void setIdItemVenda(int idItemVenda) {
		this.idItemVenda = idItemVenda;
	}
	
	public Date getDataVenda() {
		return dataVenda;
	}
	
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public String getProduto() {
		return produto;
	}
	
	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	public Integer getQuantidade() {
		return quantidade;
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
	
	public BigDecimal getTotalVenda() {
		return totalVenda;
	}
	
	public void setTotalVenda(BigDecimal totalVenda) {
		this.totalVenda = totalVenda;
	}
	
	public int getIdFormaPagto() {
		return idFormaPagto;
	}
	
	public void setIdFormaPagto(int idFormaPagto) {
		this.idFormaPagto = idFormaPagto;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	@Override
	public String toString() {
		return "Venda [idVenda=" + idVenda + ", idItemVenda=" + idItemVenda + ", dataVenda=" + dataVenda + ", produto="
				+ produto + ", quantidade=" + quantidade + ", preco=" + preco + ", totalVenda=" + totalVenda
				+ ", idFormaPagto=" + idFormaPagto + "]";
	}
	
	
	

}
