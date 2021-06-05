package br.com.unip.modelo;

import java.sql.Date;

public class Cliente {
	
	private Integer idCliente;
	private String rg;
	private String cpf;
	private String nome;
	private Date dataDeCadastro;
	private int idEnderecoCliente;
	private String telefone;
	private String email;
	
	
	
	
	public Cliente(Integer idCliente, String rg, String cpf, String nome, Date dataDeCadastro, int idEnderecoCliente,
			String telefone, String email) {
		super();
		this.idCliente = idCliente;
		this.rg = rg;
		this.cpf = cpf;
		this.nome = nome;
		this.dataDeCadastro = dataDeCadastro;
		this.idEnderecoCliente = idEnderecoCliente;
		this.telefone = telefone;
		this.email = email;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	public int getIdEnderecoCliente() {
		return idEnderecoCliente;
	}
	public void setIdEnderecoCliente(int idEnderecoCliente) {
		this.idEnderecoCliente = idEnderecoCliente;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", rg=" + rg + ", cpf=" + cpf + ", nome=" + nome
				+ ", dataDeCadastro=" + dataDeCadastro + ", idEnderecoCliente=" + idEnderecoCliente + ", telefone="
				+ telefone + ", email=" + email + "]";
	}
	
	

}
