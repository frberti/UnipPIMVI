package br.com.unip.modelo;

public class NivelUsuario {
	
	private int idNivel;
	private String nivel;
	
	
	
	public NivelUsuario(int idNivel, String nivel) {
		super();
		this.idNivel = idNivel;
		this.nivel = nivel;
	}
	public int getIdNivel() {
		return idNivel;
	}
	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}
	
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	@Override
	public String toString() {
		return "NivelUsuario [idNivel=" + idNivel + ", nivel=" + nivel + "]";
	}
	
	
	
}
