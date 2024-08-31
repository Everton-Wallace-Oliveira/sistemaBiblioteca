package loan;

import java.util.Calendar;

import book.Livro;
import data.CalculaData;
import user.Usuario;

public class Reserva extends CalculaData{

	private Usuario usuario;
	private Livro livroBase;
	private Calendar dataReserva;

	
	public Reserva(Usuario usuario, Livro livroBase) {
		this.usuario = usuario;
		this.livroBase = livroBase;
		this.dataReserva = obterDataAtual();
	}
	
	public Calendar getDataReserva() {
		return dataReserva;
	}
	

	public void exibeInformacoes() {
		System.out.println("Reserva [usuario=" + usuario.getNome() + ", livroBase=" + livroBase.getTitulo() + ", dataReserva=" + dataReserva + "]"); 
	}
	
	 public Usuario getUsuario() {
	        return usuario;
	    }

	@Override
	public String toString() {
		return "Reserva [usuario=" + usuario + ", livroBase=" + livroBase + ", dataReserva=" + dataReserva + "]";
	}

}
