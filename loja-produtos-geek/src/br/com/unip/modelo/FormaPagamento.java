package br.com.unip.modelo;

public class FormaPagamento {
	
	private int idFormaPgto;
	private String formaPgto;
	
	
	
	public FormaPagamento(Integer idFormaPgto, String formaPgto) {
		super();
		this.idFormaPgto = idFormaPgto;
		this.formaPgto = formaPgto;
	}
	public int getIdFormaPgto() {
		return idFormaPgto;
	}
	public void setIdFormaPgto(int idFormaPgto) {
		this.idFormaPgto = idFormaPgto;
	}
	public String getFormaPagto() {
		return formaPgto;
	}
	public void setFormaPagto(String formaPagto) {
		this.formaPgto = formaPagto;
	}
	@Override
	public String toString() {
		return "FormaPagamento [idFormaPgto=" + idFormaPgto + ", formaPagto=" + formaPgto + "]";
	}
	
	
	
}
