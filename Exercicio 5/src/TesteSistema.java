import java.io.IOException;

public class TesteSistema {
    public static void main(String[] args) {
        SistemaStreaming sistema = new GerenciadorDeFilmes();

        try {
            System.out.println("--- 1. CADASTRANDO DADOS ---");
            sistema.cadastrarFilme(new Filme("Matrix", "Lana e Lilly Wachowski", 1999));
            sistema.cadastrarFilme(new Filme("O Senhor dos Anéis", "Peter Jackson", 2001));
            sistema.cadastrarFilme(new Filme("Interestelar", "Christopher Nolan", 2014));
            System.out.println("Filmes cadastrados com sucesso!\n");

            System.out.println("--- 2. PESQUISANDO DADOS ---");
            String busca = "Matrix";
            Filme filmeEncontrado = sistema.pesquisarFilme(busca);
            if (filmeEncontrado != null) {
                System.out.println("Filme encontrado: " + filmeEncontrado);
            } else {
                System.out.println("Filme '" + busca + "' não encontrado.");
            }
            System.out.println();

            System.out.println("--- 3. REMOVENDO DADOS ---");
            String remocao = "Interestelar";
            System.out.println("Removendo o filme: " + remocao);
            sistema.removerFilme(remocao);

            System.out.println("\n--- 4. LISTANDO CATÁLOGO FINAL ---");
            for (Filme f : sistema.listarTodos()) {
                System.out.println(f);
            }

        } catch (IOException e) {
            System.err.println("Erro de Entrada/Saída durante a operação: " + e.getMessage());
        }
    }
}
