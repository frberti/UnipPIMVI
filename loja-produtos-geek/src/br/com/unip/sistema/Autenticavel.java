package br.com.unip.sistema;

public interface Autenticavel {
	
	public abstract void setSenha(int senha);
	//public abstract void setLogin(String login);
	public abstract boolean autentica(int senha);

}
