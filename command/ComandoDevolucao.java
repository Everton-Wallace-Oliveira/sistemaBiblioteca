package command;

import book.Livro;
import repository.Repositorio;
import user.Usuario;

public class ComandoDevolucao implements Comando {

	@Override
	public void executar(Parametros parametros) {
		String codigoUsuario = parametros.getCodigoUm();
		String codigoLivro = parametros.getCodigoDois();
		Repositorio repositorio = Repositorio.getInstancia();
		Usuario usuario = repositorio.buscaUsuarioPorCodigo(codigoUsuario);
		Livro livro = repositorio.buscaLivroPorCodigo(codigoLivro);

		if (usuario == null) {
			System.out.println("Usuário não encontrado.");
			return;
		}
		if (livro == null) {
			System.out.println("Livro não encontrado.");
			return;
		}

		livro.removeEmprestimo(usuario);
		System.out.println("Livro devolvido com sucesso!");

	}
}
