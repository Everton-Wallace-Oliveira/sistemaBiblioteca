package command;

import repository.Repositorio;
import user.Usuario;

public class ComandoConsultarUsuario implements Comando{
	
	@Override
	public void executar(Parametros parametros) {
		String codigoUsuario = parametros.getCodigoUm();
		Repositorio repositorio = Repositorio.getInstancia();
		Usuario usuario = repositorio.buscaUsuarioPorCodigo(codigoUsuario);
		
		if (usuario == null) {
			System.out.println("FALHA: usuário não encontrado.");
			return;
		}
		usuario.exibeInformacoes();
		
	}
}
