package map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livrariaOnlineMap;

    public LivrariaOnline() {
        this.livrariaOnlineMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco){
        livrariaOnlineMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo){
        if (livrariaOnlineMap.isEmpty()){
            throw new RuntimeException("Coleção está vazia");
        }

        String keyLivroParaRemover = null;

        for (Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet()){
            if(entry.getValue().getTitulo().equalsIgnoreCase(titulo)){
                keyLivroParaRemover = entry.getKey();
            }
        }

        livrariaOnlineMap.remove(keyLivroParaRemover);
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        if (livrariaOnlineMap.isEmpty()){
            throw new RuntimeException("Coleção está vazia");
        }

        List<Map.Entry<String, Livro>> livros = new ArrayList<>(livrariaOnlineMap.entrySet());

        livros.sort(new ComparatorPorPreco());

        Map<String, Livro> livrosPorPreco = new LinkedHashMap<>();

        for(Map.Entry<String, Livro> entry : livros){
            livrosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosPorPreco;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor){
        if (livrariaOnlineMap.isEmpty()){
            throw new RuntimeException("Coleção está vazia");
        }

        Map<String, Livro> pequisaLivrosPorAutor = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet()){
            if(entry.getValue().getAutor().equalsIgnoreCase(autor)){
                pequisaLivrosPorAutor.put(entry.getKey(), entry.getValue());
            }
        }

        if(pequisaLivrosPorAutor.isEmpty()){
            throw new RuntimeException("Livros não encontrados para esse autor");
        }

        return pequisaLivrosPorAutor;
    }

    public Map<String, Livro> obterLivroMaisCaro(){
        if (livrariaOnlineMap.isEmpty()){
            throw new RuntimeException("Coleção está vazia");
        }

        Map<String, Livro> livroMaisCaro = new LinkedHashMap<>();
        double maiorPrecoLivro = Double.MIN_VALUE;

        for (Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet()){
            if(entry.getValue().getPreco() > maiorPrecoLivro){
                maiorPrecoLivro = entry.getValue().getPreco();
            }
        }

        for (Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet()){
            if(entry.getValue().getPreco() == maiorPrecoLivro){
                livroMaisCaro.put(entry.getKey(), entry.getValue());
            }
        }

        return livroMaisCaro;
    }

    public Map<String, Livro> exibirLivroMaisBarato(){
        if (livrariaOnlineMap.isEmpty()){
            throw new RuntimeException("Coleção está vazia");
        }

        Map<String, Livro> livroMaisBarato = new LinkedHashMap<>();
        double menorPrecoLivro = Double.MAX_VALUE;

        for (Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet()){
            if(entry.getValue().getPreco() < menorPrecoLivro){
                menorPrecoLivro = entry.getValue().getPreco();
            }
        }

        for (Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet()){
            if(entry.getValue().getPreco() == menorPrecoLivro){
                livroMaisBarato.put(entry.getKey(), entry.getValue());
            }
        }

        return livroMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        // Adiciona os livros à livraria online
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", "1984", "George Orwell", 50d);
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", "A Revolução dos Bichos", "George Orwell", 7.05d);
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", "Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d);
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", "Malorie", "Josh Malerman", 5d);
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", "E Não Sobrou Nenhum", "Agatha Christie", 50d);
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", "Assassinato no Expresso do Oriente", "Agatha Christie", 5d);

        // Exibe todos os livros ordenados por preço
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        //Exibe todos os livros ordenados por autor
        System.out.println("Livros ordenados por autor: \n" + livrariaOnline.pesquisarLivrosPorAutor("Agatha Christie"));

        // Pesquisa livros por autor
        String autorPesquisa = "Josh Malerman";
        livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

        // Obtém e exibe o livro mais caro
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        // Obtém e exibe o livro mais barato
        System.out.println("Livro mais barato: " + livrariaOnline.exibirLivroMaisBarato());

        // Remover um livro pelo título
        livrariaOnline.removerLivro("1984");
        System.out.println(livrariaOnline.livrariaOnlineMap);

    }
}
