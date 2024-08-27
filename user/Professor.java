package user;

public class Professor extends Usuario implements Observador {
	private int qtdNotificacoes;
	private static int limiteDiasEmprestimo = 7;

	public Professor(String nome, String codigoIdentificacao) {
		super(nome, codigoIdentificacao);
		this.qtdNotificacoes = 0;
	}

	public void atualiza() {
		++this.qtdNotificacoes;
	}

	public int getQtdNotificacoes() {
		return this.qtdNotificacoes;
	}

	@Override
	public int getLimiteDiasEmprestimo() {
		return limiteDiasEmprestimo;
	}

	@Override
	public RegraEmprestimo getRegraEmprestimo() {
		return RegraEmprestimoProfessor.getInstancia();
	}
}
