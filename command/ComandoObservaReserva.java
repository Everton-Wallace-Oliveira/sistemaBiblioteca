package command;

import book.Livro;
import repository.Repositorio;
import user.Observador;
import user.Usuario;

public class ComandoObservaReserva implements Comando {

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
          livro.adicionaObservador((Observador) usuario);
          System.out.println("Observador adicionado com sucesso para o usuário: " + usuario.getNome() + " e o livro: " + livro.getTitulo());
  
    }
}
