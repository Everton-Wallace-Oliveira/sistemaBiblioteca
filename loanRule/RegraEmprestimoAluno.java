package loanRule;
import book.Livro;
import user.Aluno;
import user.Usuario;

public class RegraEmprestimoAluno extends RegraEmprestimo {
	private static RegraEmprestimoAluno minhaInstancia;
	
	private RegraEmprestimoAluno() {
		
	}
	
	public static RegraEmprestimo getInstancia() {
		if (minhaInstancia == null)
			minhaInstancia = new RegraEmprestimoAluno();
		
		return minhaInstancia;
	}

	@Override
	public boolean haExemplarDisponivel(Usuario usuario, Livro livro) {
		
		if (livro.getQtdExemplaresDisponiveis() > 0) {
			
			if (livro.getQtdReservasFeitas() >= livro.getQtdExemplaresDisponiveis()) {
				if (livro.haReservaFeita(usuario)) {
					
					return true;
				}
				
				System.out.println("Motivo: há exemplares disponíveis apenas para quem fez reserva.");
				
				return false;
			}
			
			return true;
		}
		
		System.out.println("Motivo: não há exemplares disponíveis para empréstimo");
		
		return false;
	}

	@Override
	public boolean verificarCondicoesAdicionais(Usuario usuario, Livro livro) {
		return verificarLimiteDeLivros(usuario);
	}
	
	public boolean verificarLimiteDeLivros(Usuario usuario) {
		Aluno aluno = (Aluno)usuario;
		if (usuario.getQtdLivrosEmprestados() == aluno.getMaxLivrosEmprestimo()) {
			System.out.printf("Motivo: limite de empréstimo atingido");
			return false;
		}
				
		return true;
	}
}
