package command;

import java.util.List;

import book.Livro;
import loan.Reserva;
import repository.Repositorio;

public class ComandoObservaReserva implements Comando {

    @Override
    public void executar(Parametros parametros) {
        String codigoLivro = parametros.getCodigoDois();
        Repositorio repositorio = Repositorio.getInstancia();
        Livro livro = repositorio.buscaLivroPorCodigo(codigoLivro);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        List<Reserva> reservas = livro.getReservas();

        if (reservas == null || reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada para o livro: " + livro.getTitulo());
            return;
        }

        System.out.println("Reservas para o livro: " + livro.getTitulo());
        for (Reserva reserva : reservas) {
            System.out.println("Reserva feita por: " + reserva.getUsuario().getNome() + 
                               ", Data da reserva: " + reserva.getDataReserva());
        }
    }
}
