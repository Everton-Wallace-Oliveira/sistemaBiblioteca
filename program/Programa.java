package program;

import command.Parametros;

public class Programa {
	public static void main(String[] args) {
		SistemaBiblioteca sistema = SistemaBiblioteca.getInstancia();
		LeitorDeComados leitor = LeitorDeComados.getInstancia();
		
		System.out.println("Bem vindo ao sistema!");
		
		while (true) {
			String comando = leitor.lerComando();
			Parametros parametros = leitor.lerParametros();
			
			sistema.executarComando(comando, parametros);
		}
	}
}
