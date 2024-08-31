package command;

import book.Exemplar;
import book.Livro;
import loan.Emprestimo;
import loanRule.RegraEmprestimo;
import loanRule.RegraEmprestimoAluno;
import loanRule.RegraEmprestimoProfessor;
import repository.Repositorio;
import user.Aluno;
import user.Professor;
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
            System.out.println("Usuário não encontrado.");
            return;
        }
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        RegraEmprestimo regraEmprestimo = usuario.getRegraEmprestimo();
        Exemplar exemplar = regraEmprestimo.verificarCondicoesEmprestimo(usuario, livro);
        if (exemplar == null) {
        	System.out.println("Empréstimo não pode ser realizado devido às condições de empréstimo.");
            
        }else {
        	 Emprestimo emprestimo = new Emprestimo(usuario, exemplar);
             usuario.adicionarEmprestimo(emprestimo);
             System.out.println("Empréstimo realizado com sucesso para o usuário: " + usuario.getNome() + " com o livro: " + livro.getTitulo());
        }
       
    }
}

