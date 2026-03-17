import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeDados {
    private final String ARQUIVO = "filmes.dat";

    // Grava a lista de objetos no arquivo
    public void gravarDados(List<Filme> filmes) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            out.writeObject(filmes);
        }
    }

    // Recupera a lista de objetos do arquivo
    @SuppressWarnings("unchecked")
    public List<Filme> recuperarDados() throws IOException {
        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Filme>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Classe não encontrada ao ler o arquivo", e);
        }
    }
}
