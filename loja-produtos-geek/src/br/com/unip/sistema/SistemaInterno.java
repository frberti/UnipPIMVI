package br.com.unip.sistema;

public class SistemaInterno {
	
	private int senha = 2222;

	public void autenticador(Autenticavel autenticavel) {
		
		if (autenticavel.autentica(this.senha)) {
			System.out.println("Pode entrar no sistema");
		} else {
			System.out.println("Não pode entrar no sistema");
		}
		
		
	}

}
