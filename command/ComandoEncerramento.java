package command;

public class ComandoEncerramento implements Comando {

	@Override
	public void executar(Parametros parametros) {
		System.out.println("Programa finalizado!");
		System.exit(0);
	}
	
}
