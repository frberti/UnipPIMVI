package br.com.unip.modelo;

public class Endereco {
	
	private Integer enderecoId;
	private String logradouro;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private Integer cep;
	
	
	
	
	public Endereco(Integer enderecoId, String logradouro, String rua, Integer numero, String bairro, String cidade,
			Integer cep) {
		super();
		this.enderecoId = enderecoId;
		this.logradouro = logradouro;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}

	public Integer getEnderecoId() {
		return enderecoId;
	}
	
	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public Integer getCep() {
		return cep;
	}
	
	public void setCep(Integer cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [enderecoId=" + enderecoId + ", logradouro=" + logradouro + ", rua=" + rua + ", numero="
				+ numero + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + "]";
	}

	

}
