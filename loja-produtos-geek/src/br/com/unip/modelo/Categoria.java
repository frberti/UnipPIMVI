package br.com.unip.modelo;

public class Categoria {

	private int idCat;
	private String categoria;
	
	public Categoria(int idCat, String categoria) {
		this.idCat = idCat;
		this.categoria = categoria;
	}
	public Integer getIdCat() {
		return idCat;
	}
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Categoria [idCat=" + idCat + ", categoria=" + categoria + "]";
	}
	
	

}
