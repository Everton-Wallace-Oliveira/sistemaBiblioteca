package loan;

import java.util.Calendar;

import book.Livro;
import date.CalculaData;
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
	
	public void desfazerReserva() {
        usuario.removeReserva(this);
    }
	
	 public Usuario getUsuario() {
	        return usuario;
	    }

}
