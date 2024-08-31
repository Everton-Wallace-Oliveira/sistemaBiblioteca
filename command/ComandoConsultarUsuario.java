package command;

import repository.Repositorio;
import user.Usuario;

public class ComandoConsultarUsuario implements Comando{
	
	@Override
	public void executar(Parametros parametros) {
		String codigoUsuario = parametros.getCodigoUm();
		Repositorio repositorio = Repositorio.getInstancia();
		Usuario usuario = repositorio.buscaUsuarioPorCodigo(codigoUsuario);
		usuario.exibeInformacoes();
		
	}
}
