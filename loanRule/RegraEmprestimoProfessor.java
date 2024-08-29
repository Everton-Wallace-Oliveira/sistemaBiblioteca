package loanRule;
import book.Livro;
import user.Usuario;

public class RegraEmprestimoProfessor extends RegraEmprestimo {
	private static RegraEmprestimoProfessor minhaInstancia;
	
	private RegraEmprestimoProfessor() {
		
	}
	
	public static RegraEmprestimo getInstancia() {
		if (minhaInstancia == null)
			minhaInstancia = new RegraEmprestimoProfessor();
		
		return minhaInstancia;
	} 
	
	@Override
	public boolean haExemplarDisponivel(Usuario usuario, Livro livro) {
		if (livro.getQtdExemplaresDisponiveis() > 0) 
			return true;
		
		System.out.println("Motivo: não há exemplares disponíveis para empréstimo");
		
		return false;
	}

	@Override
	public boolean verificarCondicoesAdicionais(Usuario usuario, Livro livro) {
		return true;
	}	
}
