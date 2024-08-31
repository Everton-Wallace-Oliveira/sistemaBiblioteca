package loan;

import java.util.Calendar;

import book.Exemplar;
import date.CalculaData;
import user.Usuario;

public class Emprestimo extends CalculaData {

	private Usuario usuario;
	private Exemplar exemplar;
	private Calendar dataEmprestimo;
	private Calendar dataDevolucao;

	public Emprestimo(Usuario usuario, Exemplar exemplar) {
		this.usuario = usuario;
		this.exemplar = exemplar;
		this.dataEmprestimo = obterDataAtual();
		this.dataDevolucao = prazoEstimado(usuario.getLimiteDiasEmprestimo());
	}

	public boolean estaEmAtraso() {
		Calendar dataAtual = Calendar.getInstance();
		boolean emAtraso = this.dataDevolucao.after(dataAtual);
		return emAtraso;
	}
	
	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public Exemplar getExemplar() {
		return exemplar;
	}
	
	public void desfazerEmprestimo() {
        usuario.removeEmprestimo(this);
        exemplar.devolverExemplar();
    }

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}
	
	 public Usuario getUsuario() {
	        return usuario;
	    }
	
	public boolean ehDonoDoEmprestimo(Usuario usuario) {
		boolean ehValido;
		if(this.usuario == usuario) {
			ehValido = true;
		}else {
			ehValido = false;
		}
		return ehValido;
	}

	
}
