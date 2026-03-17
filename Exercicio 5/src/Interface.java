import java.io.IOException;
import java.util.List;

public interface SistemaStreaming {
    void cadastrarFilme(Filme filme) throws IOException;
    Filme pesquisarFilme(String titulo) throws IOException;
    void removerFilme(String titulo) throws IOException;
    List<Filme> listarTodos() throws IOException;
}
