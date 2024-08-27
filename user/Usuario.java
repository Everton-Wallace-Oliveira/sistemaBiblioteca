package user;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class Usuario {
	private String nome;
	private String codigoIdentificacao;
	private RegraEmprestimo regraEmprestimo;
	private List<Emprestimo> emprestimosCorrentes;
	private List<Emprestimo> emprestimosPassados;
	private List<Reserva> reservas;
	
	
	public Usuario(String nome, String codigoIdentificacao) {
		this.nome = nome;
		this.codigoIdentificacao = codigoIdentificacao;
		this.emprestimosCorrentes = new ArrayList<Emprestimo>();
		this.emprestimosPassados = new ArrayList<Emprestimo>();
		this.reservas = new ArrayList<Reserva>();
	}
	
	public boolean comparaCodigoIdentificacao(String codigoUsuario) {
		return this.codigoIdentificacao.equals(codigoUsuario);
	}
	
	public abstract int getLimiteDiasEmprestimo();

	public abstract RegraEmprestimo getRegraEmprestimo();
	
	public int getQtdLivrosEmprestados() {
		return this.emprestimosCorrentes.size();
	}
	
	public boolean usuarioEmDebito() {
		for (Emprestimo emprestimo: this.emprestimosCorrentes) {
			if (empestimo.estaEmAtraso())
				System.out.println("Motivo: o(a) usuário(a) está com livros em débito.");
				return true;
		}
		
		return false;
	}
	
	public void exibeInformacoes() {
		System.out.printf("Exibindo informações do usuário %s:\n", this.codigoIdentificacao);
		System.out.println("EMPRÉSTIMOS");
		
		for (Emprestimo emprestimo: this.emprestimosCorrentes) {
			System.out.printf("%s - em curso\n", emprestimo.toString());
		}
		
		for (Emprestimo emprestimo: this.emprestimosPassados) {
			System.out.printf("%s - finalizado\n", emprestimo.toString());
		}
		
		System.out.println("RESERVAS");
		
		for (Reserva reserva: this.reservas) {
			System.out.printf("%s\n", reserva.toString());
		}
	}
	
	public void adicionarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void adicionarEmprestimo(Emprestimo emprestimo) {
		this.emprestimosCorrentes.add(emprestimo);
	}
	
	public void removeReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}
	
	public void removeEmprestimo(Emprestimo emprestimo) {
		this.emprestimosCorrentes.remove(emprestimo);
		this.emprestimosPassados.add(emprestimo);
	}

	public String getNome() {
		return this.nome;
	}

	public String getCodigoIdentificacao() {
		return this.codigoIdentificacao;
	}

	public List<Emprestimo> getEmprestimosCorrentes() {
		return this.emprestimosCorrentes;
	}

	public List<Emprestimo> getEmprestimosPassados() {
		return this.emprestimosPassados;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}
}
