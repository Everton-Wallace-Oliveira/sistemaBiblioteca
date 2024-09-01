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
			System.out.println("FALHA: usuário não encontrado.");
			return;
		}
		if (livro == null) {
			System.out.println("FALHA: livro não encontrado.");
			return;
		}

		if (livro.removeEmprestimo(usuario)) {
			System.out.printf("SUCESSO: devolução do livro %s concluída para o usuário %s.\n", livro.getTitulo(), usuario.getNome());
			return;
		}
		
		System.out.printf("FALHA: nenhum empréstimo do livro %s encontrado para o usuário %s.\n", livro.getTitulo(), usuario.getNome());

	}
}
