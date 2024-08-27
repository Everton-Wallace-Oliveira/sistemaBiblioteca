package program;
import java.util.HashMap;

import command.Comando;
import command.ConsultarLivroComando;
import command.DevolverComando;
import command.EmprestarComando;
import command.Parametros;

public class Sistema {
	private HashMap<String, Comando> comandos = new HashMap<String, Comando>();

	private void initComandos() {
		comandos.put("emp", new EmprestarComando());
		comandos.put("dev", new DevolverComando());
		comandos.put("liv", new ConsultarLivroComando());
	}
	
	public void executarComando(String strComando, Parametros parametros) {
		Comando comando = comandos.get(strComando);
		comando.executar(parametros);
	}
	

}
