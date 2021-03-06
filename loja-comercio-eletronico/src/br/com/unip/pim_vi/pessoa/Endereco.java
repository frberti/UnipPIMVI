package br.com.unip.pim_vi.pessoa;

public class Endereco {
	
	private String cidade;
	private String rua;
	private String bairro;
	private Integer cep;
	private Integer numero;

	public Endereco(String cidade, String rua, String bairro, Integer cep, Integer numero) {
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Endereco [cidade=" + cidade + ", rua=" + rua + ", bairro=" + bairro + ", cep=" + cep + ", numero="
				+ numero + "]";
	}
	
	
	

}
