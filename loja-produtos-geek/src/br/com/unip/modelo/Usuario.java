package br.com.unip.modelo;

public class Usuario {
	
	private int idUsuario;
	private String login;
	private String senha;
	private int idNivelUsuario;
	
	
	
	public Usuario(int idUsuario, String login, String senha, int idNivelUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
		this.idNivelUsuario = idNivelUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getIdNivelUsuario() {
		return idNivelUsuario;
	}
	
	public void setIdNivelUsuario(int idNivelUsuario) {
		this.idNivelUsuario = idNivelUsuario;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", login=" + login + ", senha=" + senha + ", idNivelUsuario="
				+ idNivelUsuario + "]";
	}
	
	

}
