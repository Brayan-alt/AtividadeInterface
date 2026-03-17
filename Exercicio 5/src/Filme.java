import java.io.Serializable;

public class Filme implements Serializable {
    private static final long serialVersionUID = 1L;

    private String titulo;
    private String diretor;
    private int anoLancamento;

    public Filme(String titulo, String diretor, int anoLancamento) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
    }

    public String getTitulo() { return titulo; }
    public String getDiretor() { return diretor; }
    public int getAnoLancamento() { return anoLancamento; }

    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", diretor='" + diretor + '\'' +
                ", anoLancamento=" + anoLancamento +
                '}';
    }
}
