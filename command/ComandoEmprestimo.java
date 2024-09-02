package command;

import book.Livro;
import loanRule.RegraEmprestimo;
import repository.Repositorio;
import user.Usuario;

public class ComandoEmprestimo implements Comando {

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

        RegraEmprestimo regraEmprestimo = usuario.getRegraEmprestimo();
        
        if (!regraEmprestimo.verificarCondicoesEmprestimo(usuario, livro)) {
        	System.out.printf("FALHA: empréstimo do livro %s não pode ser realizado para o usuário %s.\n", livro.getTitulo(), usuario.getNome());
        	return;
        }
        
        livro.adicionaEmprestimo(usuario);
        System.out.printf("SUCESSO: empréstimo do livro %s realizado para o usuário %s.\n",livro.getTitulo(), usuario.getNome());
    }
}

