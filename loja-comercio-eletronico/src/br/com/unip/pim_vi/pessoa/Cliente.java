package br.com.unip.pim_vi.pessoa;

import java.sql.Date;

import br.com.unip.pim_vi.modelo.Autenticavel;

public class Cliente extends Pessoa implements Autenticavel {

	private Integer idCliente;
	private Date dataDeCadastro;
	private Autenticacao autenticador;

	public Cliente() {
		this.autenticador = new Autenticacao();
	}

	public Integer getCodigo() {
		return idCliente;
	}

	public void setCodigo(Integer codigo) {
		this.idCliente = codigo;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}

	@Override
	public void setLogin(String login) {
		this.autenticador.setLogin(login);

	}

	@Override
	public boolean autentica(int senha, String login) {
		return this.autenticador.autentica(senha);
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + idCliente + ", dataDeCadastro=" + dataDeCadastro + "]";
	}

}