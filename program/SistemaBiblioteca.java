package program;
import java.util.HashMap;

import command.*;

public class SistemaBiblioteca {
	private HashMap<String, Comando> comandos;
	private static SistemaBiblioteca minhaInstancia;
	
	private SistemaBiblioteca() {
		this.comandos = new HashMap<String, Comando>();
		this.inicializaComandos();
	}
	
	public static SistemaBiblioteca getInstancia() {
		if (minhaInstancia == null)
			minhaInstancia = new SistemaBiblioteca();
		
		return minhaInstancia;
	}
	
	private void inicializaComandos() {
		this.comandos.put("emp", new ComandoEmprestimo());
		this.comandos.put("dev", new ComandoDevolucao());
		this.comandos.put("liv", new ComandoConsultarLivro());
		this.comandos.put("res", new ComandoReserva());
		this.comandos.put("usu", new ComandoConsultarUsuario());
		this.comandos.put("ntf", new ComandoConsultaNotificacao());
		this.comandos.put("obs", new ComandoObservaReserva());
		this.comandos.put("sai", new ComandoEncerramento());
	}
	
	public void executarComando(String strComando, Parametros parametros) {
		Comando comando = this.comandos.get(strComando);
		comando.executar(parametros);
	}
}
