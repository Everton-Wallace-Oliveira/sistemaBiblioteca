package command;
import book.Livro;
import repository.Repositorio;

public class ComandoConsultarLivro implements Comando {

	@Override
	public void executar(Parametros parametros) {
		String codigoLivro = parametros.getCodigoUm();
		Repositorio repositorio = Repositorio.getInstancia();
		Livro livro = repositorio.buscaLivroPorCodigo(codigoLivro);
		
		if (livro == null) {
            System.out.println("FALHA: livro não encontrado.");
            return;
        }
		
		livro.exibeInformacoes();
	}

}
