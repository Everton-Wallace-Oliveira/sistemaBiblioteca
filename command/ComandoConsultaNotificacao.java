package command;

import repository.Repositorio;
import user.Observador;
import user.Usuario;

public class ComandoConsultaNotificacao implements Comando{
	@Override
	public void executar(Parametros parametros) {
		String codigoUsuario = parametros.getCodigoUm();
		Repositorio repositorio = Repositorio.getInstancia();
		Usuario usuario = repositorio.buscaUsuarioPorCodigo(codigoUsuario);

		if (usuario == null) {
			System.out.println("Usuário não encontrado.");
			return;
		}
		Observador aux = (Observador) usuario;
		System.out.println("Usuário " + usuario.getNome() + " recebeu " + aux.getQtdNotificacoes() + " notificações.");
		
	}
}
