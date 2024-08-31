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
            System.out.println("Usuário não encontrado.");
            return;
        }

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (livro.buscaReservaDeUsuario(usuario) != null) {
            System.out.println("O usuário já tem uma reserva para este livro.");
            return;
        }

        livro.adicionaReserva(usuario);
        System.out.println("Reserva feita com sucesso para o usuário: " + usuario.getNome());
    }
}