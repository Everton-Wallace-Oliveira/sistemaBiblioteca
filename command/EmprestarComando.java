package command;
import book.Livro;
import repository.Repositorio;
import user.Usuario;

public class EmprestarComando implements Comando {

	@Override
	public void executar(Parametros parametros) {
		String codigoUsuario = parametros.getCodigoUm();
		String codigoLivro = parametros.getCodigoDois();
		Repositorio repositorio = Repositorio.getInstancia();
		Usuario usuario = repositorio.buscarUsuarioPorCodigo(codigoUsuario);
		Livro livro = repositorio.buscarLivroPorCodigo(codigoLivro);
		//usuario.pegarLivro(livro);

	}

}
