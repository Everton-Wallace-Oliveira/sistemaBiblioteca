package book;

import java.util.ArrayList;
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
		Reserva reserva = new Reserva(usuario, this);
		usuario.adicionarReserva(reserva);
	    reservas.add(reserva); 
		if(reservas.size() >  2) {
			this.notifica();
		}
    }
    
    public void adicionaEmprestimo(Usuario usuario) {
        Exemplar exemplar = obterExemplarDisponivel();
        if (exemplar != null) {
            Emprestimo emprestimo = new Emprestimo(usuario, exemplar);
            usuario.adicionarEmprestimo(emprestimo);
            this.removeReserva(usuario);
            emprestimos.add(emprestimo);
            exemplar.obterExemplar();
        }
    }
    public Exemplar obterExemplarDisponivel() {
        for (Exemplar exemplar : exemplares) {
            if (!exemplar.isEmprestado()) { 
                return exemplar;
            }
        }
        return null;
    }
    
    public void removeReserva(Usuario usuario) {
    	Reserva reservaParaRemover = buscaReservaDeUsuario(usuario);
        if(reservaParaRemover != null) {
        	reservaParaRemover.desfazerReserva();
        	reservas.remove(reservaParaRemover);
        }     
    }
    
    public boolean removeEmprestimo(Usuario usuario) {
        Emprestimo emprestimoParaRemover = buscaEmprestimoDeUsuario(usuario);
        if(emprestimoParaRemover != null) {
        	emprestimoParaRemover.desfazerEmprestimo();
        	emprestimos.remove(emprestimoParaRemover);
        	return true;
        }
        
        return false;
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
    
    public void adicionarExemplar(String codigoExemplar) { 	
        exemplares.add(new Exemplar(codigoExemplar, this));
    }
    
    public int getQtdExemplaresDisponiveis() {
        return (this.exemplares.size() - this.emprestimos.size());
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
    
    public void exibeInformacoes() {
        System.out.printf("Título do livro: %s\n", this.titulo);

        int qtdReservas = this.reservas.size();
        System.out.printf("Quantidade de reservas: %d\n", qtdReservas);

        if (qtdReservas > 0) {
            System.out.println("Usuários que fizeram reserva:");
            for (Reserva reserva : this.reservas) {
                System.out.printf("- %s", reserva.exibeInformacoesParaLivro());
            }
        }

        System.out.println("Exemplares:");
        for (Exemplar exemplar : this.exemplares) {
            System.out.printf("Código do exemplar: %s\n", exemplar.getCodigoExemplar());
            if (exemplar.isEmprestado()) {
                System.out.println("Status: Emprestado");
                
                Emprestimo emprestimo = buscaEmprestimoPorExemplar(exemplar);
                System.out.printf("%s\n", emprestimo.exibeInformacoesParaLivro());
            } else {
                System.out.println("Status: Disponível");
            }
            System.out.println();
        }
    } 
    private Emprestimo buscaEmprestimoPorExemplar(Exemplar exemplar) {
    	for(Emprestimo emprestimo: this.emprestimos) {
    		if(emprestimo.getExemplar().equals(exemplar)) {
    			return emprestimo;
    		}
    	}
    	return null;
    }


	@Override
	public void notifica() {
		for (Observador observador: observadores) {
			observador.atualiza();
		}
	}

	
	
}
