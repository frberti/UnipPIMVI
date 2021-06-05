package br.com.unip.pim_vi.pessoa;

public class Autenticacao {
	
	private Integer senha;
	private String login;
	
	public void setSenha(Integer senha) {
		this.senha = senha;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public boolean autentica(Integer senha) {
		if(this.senha == senha) {
			System.out.println("autenticou");
			return true;
		} else {
			System.out.println("Impossível autenticar");
			return false;
		}
	}

}
