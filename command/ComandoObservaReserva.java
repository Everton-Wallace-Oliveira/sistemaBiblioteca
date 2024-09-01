// Tudo OK

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
              System.out.println("FALHA: usuário não encontrado.");
              return;
          }
          if (livro == null) {
              System.out.println("FALHA: livro não encontrado.");
              return;
          }         
          
          livro.adicionaObservador((Observador) usuario);
          System.out.printf("SUCESSO: o usuário %s foi cadastrado como observador do livro %s.\n", usuario.getNome(), livro.getTitulo());
  
    }
}
