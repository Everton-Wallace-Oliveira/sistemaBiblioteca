package loanRule;
// adição de mensagem de falha
import book.Livro;
import user.Usuario;

public abstract class RegraEmprestimo {
	
	public abstract boolean haExemplarDisponivel(Usuario usuario, Livro livro);
	
	public abstract boolean verificarCondicoesAdicionais(Usuario usuario, Livro livro);
	
	public boolean verificarCondicoesEmprestimo(Usuario usuario, Livro livro) {
		return (!this.usuarioEmDebito(usuario)) && (!this.haEmprestimoEmCurso(usuario, livro)) &&
				this.haExemplarDisponivel(usuario, livro) && this.verificarCondicoesAdicionais(usuario, livro);
	}
	
	public boolean usuarioEmDebito(Usuario usuario) {
		if (usuario.usuarioEmDebito()) {
			System.out.println("FALHA: o usuário está com livros em débito.");
			return true;
		}
		
		return false;
	}
	
	public boolean haEmprestimoEmCurso(Usuario usuario, Livro livro) {
		if (livro.buscaEmprestimoDeUsuario(usuario) != null) {
			System.out.println("FALHA: o usuário já possui empréstimo deste livro em curso.");
			return true;
		}
		
		return false;
	}
}
