package book;

import user.Observador;

public interface Assunto {
	public void notifica();
	public void adicionaObservador(Observador observador);
	public void removeObservador(Observador observador);

}
