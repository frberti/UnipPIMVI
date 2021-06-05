package br.com.unip.pim_vi.pessoa;

import br.com.unip.pim_vi.modelo.Autenticavel;

public abstract class Funcionario extends Pessoa implements Autenticavel{
	
	private Integer senha;
	private Autenticacao autenticacao;
	
	public Funcionario() {
		this.autenticacao = new Autenticacao();
	}



}
