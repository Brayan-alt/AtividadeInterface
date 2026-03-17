import java.io.IOException;
import java.util.List;

public class GerenciadorDeFilmes implements SistemaStreaming {
    private GravadorDeDados gravador;

    public GerenciadorDeFilmes() {
        this.gravador = new GravadorDeDados();
    }

    @Override
    public void cadastrarFilme(Filme filme) throws IOException {
        List<Filme> filmes = gravador.recuperarDados();
        filmes.add(filme);
        gravador.gravarDados(filmes);
    }

    @Override
    public Filme pesquisarFilme(String titulo) throws IOException {
        List<Filme> filmes = gravador.recuperarDados();
        for (Filme f : filmes) {
            if (f.getTitulo().equalsIgnoreCase(titulo)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public void removerFilme(String titulo) throws IOException {
        List<Filme> filmes = gravador.recuperarDados();
        boolean removido = filmes.removeIf(f -> f.getTitulo().equalsIgnoreCase(titulo));

        if (removido) {
            gravador.gravarDados(filmes);
        }
    }

    @Override
    public List<Filme> listarTodos() throws IOException {
        return gravador.recuperarDados();
    }
}
