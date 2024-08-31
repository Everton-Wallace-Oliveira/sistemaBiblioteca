package book;

public class Exemplar {

	private String codigoExemplar;
	private Livro livroBase;
	private boolean emprestado ;
	
	public Exemplar(String codigoExemplar, Livro livroBase) {
		this.codigoExemplar = codigoExemplar;
		this.livroBase = livroBase;
		this.emprestado = false;
	}
	
	public void obterExemplar() {
        this.emprestado =  true;
    }
	
	public void devolverExemplar() {
		this.emprestado = false;
	}
	
	public void exibeInformacoes() {
		System.out.println("Exemplar [codigoExemplar=" + codigoExemplar + ", livroBase=" + livroBase.exibeInformacoes() + "]");
	}

	public boolean isEmprestado() {
		return emprestado;
	}
	
}
