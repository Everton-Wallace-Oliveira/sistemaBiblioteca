package program;
import java.util.HashMap;

import command.Comando;
import command.ComandoConsultarLivro;
import command.ComandoDevolucao;
import command.ComandoEmprestimo;
import command.Parametros;

public class Sistema {
	private HashMap<String, Comando> comandos = new HashMap<String, Comando>();

	private void initComandos() {
		comandos.put("emp", new ComandoEmprestimo());
		comandos.put("dev", new ComandoDevolucao());
		comandos.put("liv", new ComandoConsultarLivro());
	}
	
	public void executarComando(String strComando, Parametros parametros) {
		Comando comando = comandos.get(strComando);
		comando.executar(parametros);
	}
}
