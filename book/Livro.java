package book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import loan.Emprestimo;
import loan.Reserva;
import user.Observador;
import user.Usuario;

public class Livro implements Assunto{
	
	private String codigoLivro;
	private String titulo;
	private String editora;
	private List<String> autores;
	private int edicao;
	private int anoPublicacao;
	private List<Exemplar> exemplares;
	private List<Emprestimo> emprestimos;
	private List<Reserva> reservas;
	private List<Observador> observadores;
	
	public Livro(String codigoLivro, String titulo, String editora, List<String> autores, int edicao, int anoPublicacao) {
        this.codigoLivro = codigoLivro;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores != null ? autores : new ArrayList<>();
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.exemplares = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

	
	public void adicionaReserva(Usuario usuario) {
        reservas.add(new Reserva(usuario, this)); 
    }
    
    public void adicionaEmprestimo(Usuario usuario) {
        Exemplar exemplar = obterExemplarDisponivel();
        if (exemplar != null) {
            Emprestimo emprestimo = new Emprestimo(usuario, exemplar);
            emprestimos.add(emprestimo);
        }
    }
//    
//    public void adicionaEmprestimo(Emprestimo emprestimo) {
//        if (emprestimos == null) {
//            emprestimos = new ArrayList<>();
//        }
//        emprestimos.add(emprestimo);
//    }
//    
    private Exemplar obterExemplarDisponivel() {
        for (Exemplar exemplar : exemplares) {
            if (!exemplar.isEmprestado()) { 
                return exemplar;
            }
        }
        return null;
    }

    public void removeReserva(Usuario usuario) {
        Iterator<Reserva> iterator = reservas.iterator();

        while (iterator.hasNext()) {
            Reserva reserva = iterator.next();
            if (reserva.getUsuario().equals(usuario)) {
                iterator.remove(); 
                System.out.println("Reserva removida para o usuário: " + usuario.getNome());
                return;
            }
        }
        System.out.println("Nenhuma reserva encontrada para o usuário: " + usuario.getNome());
    }

    public void removeEmprestimo(Usuario usuario) {
        Iterator<Emprestimo> iterator = emprestimos.iterator();
        while (iterator.hasNext()) {
            Emprestimo emprestimo = iterator.next();
            if (emprestimo.getUsuario().equals(usuario)) {
                iterator.remove();
                System.out.println("Empréstimo removido para o usuário: " + usuario.getNome());
                return; 
            }
        }
        System.out.println("Nenhum empréstimo encontrado para o usuário: " + usuario.getNome());
    }

    public Reserva buscaReservaDeUsuario(Usuario usuario) {
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(usuario)) {
                return reserva; 
            }
        }
        return null;
    }

    public Emprestimo buscaEmprestimoDeUsuario(Usuario usuario) {
    	for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.ehDonoDoEmprestimo(usuario)) {
                return emprestimo; 
            }
        }    
        return null;
    }

    public boolean comparaCodigoIdentificacao(String codigo) {
        return this.codigoLivro.equals(codigo);
    }

    public void adicionarExemplar(Exemplar exemplar) { 	
        exemplares.add(exemplar);
    }

    public int getQtdExemplaresDisponiveis() {
        return exemplares.size();
    }

    public int getQtdReservasFeitas() {
        return reservas.size();
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public void adicionaObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void removeObservador(Observador observador) {
        observadores.remove(observador);
    }
    
	public String exibeInformacoes() {
		return "Livro [codigoLivro=" + codigoLivro + ", titulo=" + titulo + ", editora=" + editora + ", autores="
				+ autores + ", edicao=" + edicao + ", anoPublicacao=" + anoPublicacao + ", exemplaresDisponiveis="
				+ exemplares + ", exemplaresEmprestados=" + emprestimos + ", reservas=" + reservas
				+ "]";
	}


	public List<Reserva> getReservas() {
		return reservas;
	}

	@Override
	public void notifica() {
		
		
	}

	
	
}
