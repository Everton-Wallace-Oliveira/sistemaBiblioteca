// Remoção da herança com CalculaData

package loan;

import java.util.Calendar;

import book.Exemplar;
import date.CalculaData;
import user.Usuario;

public class Emprestimo {

	private Usuario usuario;
	private Exemplar exemplar;
	private Calendar dataEmprestimo;
	private Calendar dataDevolucao;

	public Emprestimo(Usuario usuario, Exemplar exemplar) {
		this.usuario = usuario;
		this.exemplar = exemplar;
		this.dataEmprestimo = CalculaData.obterDataAtual();
		this.dataDevolucao = CalculaData.prazoEstimado(usuario.getLimiteDiasEmprestimo());
	}

	public boolean estaEmAtraso() {
		Calendar dataAtual = Calendar.getInstance();
		boolean emAtraso = dataAtual.after(this.dataDevolucao);
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
	 
	 // inserindo toString
	 public String exibeInformacoesParaLivro() {
		 String string = String.format("Nome do usuário que realizou o empréstimo: %s\nData de empréstimo: %s\n", this.usuario.getNome(), CalculaData.geraDataFormatada(this.dataEmprestimo));
		 if (this.exemplar.isEmprestado())
			 string = String.format("%sData de devolução prevista: %s\n", string, CalculaData.geraDataFormatada(this.dataDevolucao));
		 else
			 string = String.format("%sData de devolução: %s\n", string, CalculaData.geraDataFormatada(this.dataDevolucao));
		 
		 return string;
	 }
	 
	 public String exibeInformacoesParaUsuario() {
		 String string = String.format("Título: %s\nData de empréstimo: %s\n", this.exemplar.getTituloExemplar(), CalculaData.geraDataFormatada(this.dataEmprestimo));
		 if (this.exemplar.isEmprestado())
			 string = String.format("%sData de devolução prevista: %s\n", string, CalculaData.geraDataFormatada(this.dataDevolucao));
		 else
			 string = String.format("%sData de devolução: %s\n", string, CalculaData.geraDataFormatada(this.dataDevolucao));
		 
		 return string;
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
