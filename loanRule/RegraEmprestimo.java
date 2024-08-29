package loanRule;
import java.util.Calendar;
import java.util.List;
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
		return usuario.usuarioEmDebito();
	}
	
	public boolean haEmprestimoEmCurso(Usuario usuario, Livro livro) {
		return livro.haEmprestimoEmCurso(usuario);
	}
}
