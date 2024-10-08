package repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import book.Livro;
import user.AlunoGraduacao;
import user.AlunoPosGraduacao;
import user.Professor;
import user.Usuario;

public class Repositorio {
	private List<Usuario> usuarios;
	private List<Livro> livros;
	private static Repositorio minhaInstancia;
	
	private Repositorio() {
		this.usuarios = new ArrayList<Usuario>();
		this.livros = new ArrayList<Livro>();
	}
	
	public static Repositorio getInstancia() {
		if (minhaInstancia == null)
			minhaInstancia = new Repositorio();
		
		return minhaInstancia;
	}
	
	public void adicionarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public void adicionarLivro(Livro livro) {
		this.livros.add(livro);
	}
	
	public Usuario buscaUsuarioPorCodigo(String codigoUsuario) {
		for (Usuario usuario : this.usuarios) {
			if (usuario.comparaCodigoIdentificacao(codigoUsuario))
				return usuario;
		}
		
		return null;
	}
	
	public Livro buscaLivroPorCodigo(String codigoLivro) {
		for (Livro livro : this.livros) {
			if (livro.comparaCodigoIdentificacao(codigoLivro))
				return livro;
		}
		
		return null;
	}
	
	public void inicializaObjetosParaTestagem() {
		Usuario usuario1 = new AlunoGraduacao("João da Silva", "123");
		Usuario usuario2 = new AlunoGraduacao("Pedro Paulo", "789");
		Usuario usuario3 = new AlunoPosGraduacao("Luiz Fernando Rodrigues", "456");
		Usuario usuario4 = new Professor("Carlos Lucena", "100");
		Usuario usuario5 = new Professor("Maria Pereira", "200");
		Usuario usuario6 = new AlunoPosGraduacao("Clara Fernandes", "300");
		
		this.adicionarUsuario(usuario1);
		this.adicionarUsuario(usuario2);
		this.adicionarUsuario(usuario3);
		this.adicionarUsuario(usuario4);
		this.adicionarUsuario(usuario5);
		this.adicionarUsuario(usuario6);
		
		Livro livro1 = new Livro("100", "Engenharia de Software", "Addison-Wesley", new ArrayList<>(Arrays.asList("Ian Sommerville")), 6, 2000);
        Livro livro2 = new Livro("101", "UML - Guia do Usuário", "Campus", new ArrayList<>(Arrays.asList("Grady Booch", "James Rumbaugh", "Ivar Jacobson")), 7, 2000);
        Livro livro3 = new Livro("200", "Code Complete", "Microsoft Press", new ArrayList<>(Arrays.asList("Steve McConnell")), 2, 2004);
        Livro livro4 = new Livro("201", "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", new ArrayList<>(Arrays.asList("Robert Martin")), 1, 2002);
        Livro livro5 = new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", new ArrayList<>(Arrays.asList("Martin Fowler")), 1, 1999);
        Livro livro6 = new Livro("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press", new ArrayList<>(Arrays.asList("Norman Fenton", "James Bieman")), 3, 2014);
        Livro livro7 = new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", new ArrayList<>(Arrays.asList("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides")), 1, 1994);
        Livro livro8 = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", new ArrayList<>(Arrays.asList("Martin Fowler")), 3, 2003);
        
        // responsabiliadde de criar é da classe livro
		
		livro1.adicionarExemplar("01");
		livro1.adicionarExemplar("02");
		livro2.adicionarExemplar("03");
		livro3.adicionarExemplar("04");
		livro4.adicionarExemplar("05");
		livro5.adicionarExemplar("06");
		livro5.adicionarExemplar("07");
		livro7.adicionarExemplar("08");
		livro7.adicionarExemplar("09");
		
		this.adicionarLivro(livro1);
		this.adicionarLivro(livro2);
		this.adicionarLivro(livro3);
		this.adicionarLivro(livro4);
		this.adicionarLivro(livro5);
		this.adicionarLivro(livro6);
		this.adicionarLivro(livro7);
		this.adicionarLivro(livro8);
	}
}
