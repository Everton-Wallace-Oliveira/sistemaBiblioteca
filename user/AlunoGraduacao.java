package user;

public class AlunoGraduacao extends Usuario implements Aluno {
	private static int maxLivrosEmprestimo = 3;
	private static int limiteDiasEmprestimo = 3;
	
	public AlunoGraduacao (String nome, String codigoIdentificacao) {
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
