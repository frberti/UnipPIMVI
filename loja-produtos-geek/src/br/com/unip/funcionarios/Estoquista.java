package br.com.unip.funcionarios;

import br.com.unip.sistema.Autenticacao;
import br.com.unip.sistema.Autenticavel;

public class Estoquista extends Funcionario implements Autenticavel {

	private Autenticacao autenticador;

	public Estoquista() {
		this.autenticador = new Autenticacao();
	}

	@Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
		
	}

	@Override
	public boolean autentica(int senha) {
		return this.autenticador.autentica(senha);
	}

}
