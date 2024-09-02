package user;
import java.util.ArrayList;

// adição método pegar qtd reserva
import java.util.List;

import loan.Emprestimo;
import loan.Reserva;
import loanRule.RegraEmprestimo;

public abstract class Usuario {
	private String nome;
	private String codigoIdentificacao;
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
	
	public int getQtdReservasFeitas() {
		return this.reservas.size();
	}
	
	public boolean usuarioEmDebito() {
		for (Emprestimo emprestimo: this.emprestimosCorrentes) {
			if (emprestimo.estaEmAtraso())
				return true;
		}
		
		return false;
	}
	
	public void exibeInformacoes() {
		System.out.printf("Exibindo informações do usuário %s:\n", this.nome);
		if (this.emprestimosCorrentes.size() > 0 || this.emprestimosPassados.size() > 0) {
			System.out.println("EMPRÉSTIMOS\n");
			
			for (Emprestimo emprestimo: this.emprestimosCorrentes) {
				System.out.printf("%sStatus: em curso\n\n", emprestimo.exibeInformacoesParaUsuario());
			}
			
			
			for (Emprestimo emprestimo: this.emprestimosPassados) {
				System.out.printf("%sStatus: finalizado\n", emprestimo.exibeInformacoesParaUsuario());
			}
		}
		else {
			System.out.println("O usuário ainda não realizou empréstimos.");
		}
		
		if (this.reservas.size() > 0) {
			System.out.println("\nRESERVAS\n");
			
			for (Reserva reserva: this.reservas) {
				System.out.printf("%s\n", reserva.exibeInformacoesParaUsuario());
			}
		}
		else {
			System.out.println("O usuário ainda não realizou reservas.");
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
