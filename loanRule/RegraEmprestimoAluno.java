package loanRule;
import book.Livro;

// atualização mensagens de falha

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
				if (livro.buscaReservaDeUsuario(usuario) != null)
					return true;
				
				System.out.println("FALHA: há exemplares disponíveis apenas para quem fez reserva.");
				
				return false;
			}
			
			return true;
		}
		
		System.out.println("FALHA: não há exemplares disponíveis para empréstimo.");
		
		return false;
	}

	@Override
	public boolean verificarCondicoesAdicionais(Usuario usuario, Livro livro) {
		return verificarLimiteDeLivros(usuario);
	}
	
	public boolean verificarLimiteDeLivros(Usuario usuario) {
		Aluno aluno = (Aluno)usuario;
		if (usuario.getQtdLivrosEmprestados() == aluno.getMaxLivrosEmprestimo()) {
			System.out.printf("FALHA: limite de empréstimo atingido.\n");
			return false;
		}
				
		return true;
	}
}
