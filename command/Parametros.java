package command;

public class Parametros {

	private String codigoUm;
	private String codigoDois;
	
	public Parametros(String codigoUm, String codigoDois) {
		this.codigoUm = codigoUm;
		this.codigoDois = codigoDois;
	}
	
	public Parametros(String codigoUm) {
		this.codigoUm = codigoUm;
	
	}
	
	public String getCodigoUm() {
		return codigoUm;
	}
	
	public String getCodigoDois() {
		return codigoDois;
	}

}
