package map.OperacoesBasicas;

import java.util.HashMap;

public class Dicionario {
    private HashMap<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra){
        if(dicionarioMap.isEmpty()){
            throw new RuntimeException("Dicionário está vazio");
        }

        dicionarioMap.remove(palavra);
    }

    public void exibirPalavras(){
        System.out.println(dicionarioMap);
    }

    public String pesquisarPorPalavra(String palavra){
        if(dicionarioMap.isEmpty()){
            throw new RuntimeException("Dicionário está vazio");
        }

        String palavraPesquisada = dicionarioMap.get(palavra);

        if(palavraPesquisada == null){
            throw new RuntimeException("Palavra não foi registrada");
        }

        return palavraPesquisada;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.exibirPalavras();

        dicionario.adicionarPalavra("estudo", "processo de estudar");
        dicionario.adicionarPalavra("sucesso", "êxito");
        dicionario.adicionarPalavra("fracasso", "falta de êxito");
        dicionario.adicionarPalavra("sorte", "força invencível a que se atribuem o rumo e os diversos acontecimentos da vida");

        dicionario.exibirPalavras();

        dicionario.removerPalavra("fracasso");
        dicionario.exibirPalavras();

        System.out.println("A definição de \"estudo\" é: " + dicionario.pesquisarPorPalavra("estudo"));

    }
}
