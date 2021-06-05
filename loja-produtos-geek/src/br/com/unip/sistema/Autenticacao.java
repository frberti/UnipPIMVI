package br.com.unip.sistema;

public class Autenticacao {
	
	private int senha;
	
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public boolean autentica(int senha) {
		if (this .senha == senha) {
			System.out.println("Acesso liberado");
			return true;
		} else {
			System.out.println("Não foi possível autenticar");
			return false;
		}
	}

}
