package program;
import command.Parametros;
import java.util.Scanner;

public class LeitorDeComados {
	private Scanner scanner;
	private static LeitorDeComados minhaInstancia;
	
	private LeitorDeComados() {
		this.scanner = new Scanner(System.in);
	}
	
	public static LeitorDeComados getInstancia() {
		if (minhaInstancia == null)
			minhaInstancia = new LeitorDeComados();
		
		return minhaInstancia;
	}
	
	
	public String lerComando() {
		String entrada = this.scanner.next();
		
		return entrada;
	}
	
	public Parametros lerParametros() {
		String entrada = this.scanner.nextLine();
		entrada = entrada.strip();
		
		String[] codigos = entrada.split(" ", 0);
		Parametros parametros;
		
		switch (codigos.length) {
			case 1:
				parametros = new Parametros(codigos[0]);
				break;
			case 2:
				parametros = new Parametros(codigos[0], codigo[1]);
				break;
		}
		
		return parametros;
	}
}
