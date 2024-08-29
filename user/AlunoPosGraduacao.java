package user;

import loanRule.RegraEmprestimo;
import loanRule.RegraEmprestimoAluno;

public class AlunoPosGraduacao extends Usuario implements Aluno {
	private static int maxLivrosEmprestimo = 4;
	private static int limiteDiasEmprestimo = 4;
	
	public AlunoPosGraduacao (String nome, String codigoIdentificacao) {
		super(nome, codigoIdentificacao);
	}

	@Override
	public int getLimiteDiasEmprestimo() {
		return limiteDiasEmprestimo;
	}

	@Override
	public int getMaxLivrosEmprestimo() {
		return maxLivrosEmprestimo;
	}

	@Override
	public RegraEmprestimo getRegraEmprestimo() {
		return RegraEmprestimoAluno.getInstancia();
	}
}
