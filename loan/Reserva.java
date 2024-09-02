// Remoção da herança com CalculaData

package loan;

import java.util.Calendar;

import book.Livro;
import date.CalculaData;
import user.Usuario;

public class Reserva {

	private Usuario usuario;
	private Livro livroBase;
	private Calendar dataReserva;

	
	public Reserva(Usuario usuario, Livro livroBase) {
		this.usuario = usuario;
		this.livroBase = livroBase;
		this.dataReserva = CalculaData.obterDataAtual();
	}
	
	public Calendar getDataReserva() {
		return dataReserva;
	}
	
	public void desfazerReserva() {
        usuario.removeReserva(this);
    }
	
	public Usuario getUsuario() {
	        return usuario;
	}
	
	public String exibeInformacoesParaUsuario() {
		return String.format("Título: %s\nData de reserva: %s\n", this.livroBase.getTitulo(), CalculaData.geraDataFormatada(this.dataReserva));
	 }
	
	public String exibeInformacoesParaLivro() {
		return String.format("%s\n", this.usuario.getNome());
	 }

}
