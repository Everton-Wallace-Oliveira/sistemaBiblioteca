package command;

import book.Livro;
import repository.Repositorio;
import user.Usuario;

public class ComandoReserva implements Comando {

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

        if (livro.buscaReservaDeUsuario(usuario) != null) {
            System.out.printf("FALHA: o usuário %s já tem uma reserva feita para o livro %s.\n", usuario.getNome(), livro.getTitulo());
            return;
        }
        
        if (usuario.getQtdReservasFeitas() == 3) {
        	System.out.printf("FALHA: o usuário %s não pode reservar o livro %s, pois atingiu o limite máximo de reservas.\n", usuario.getNome(), livro.getTitulo());
        	return;
        }

        livro.adicionaReserva(usuario);
        System.out.printf("SUCESSO: reserva do livro %s feita para o usuário %s.\n", livro.getTitulo(), usuario.getNome());
    }
}