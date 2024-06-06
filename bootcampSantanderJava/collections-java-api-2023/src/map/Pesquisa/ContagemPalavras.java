package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contagemPalavraMap;

    public ContagemPalavras() {
        this.contagemPalavraMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        contagemPalavraMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        contagemPalavraMap.remove(palavra);
    }

    public void exibirContagemPalavras(){
        System.out.println(contagemPalavraMap);
    }

    public String encontrarPalavraMaisFrequente(){
        if (contagemPalavraMap.isEmpty()){
            throw new RuntimeException("Coleção está vazia");
        }

        String palavraMaisFrequente = null;
        int numeroDeFrequencia = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : contagemPalavraMap.entrySet()){
            if(entry.getValue() > numeroDeFrequencia){
                palavraMaisFrequente = entry.getKey();
                numeroDeFrequencia = entry.getValue();
            }
        }

        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        contagemPalavras.exibirContagemPalavras();

        contagemPalavras.adicionarPalavra("palavra 1", 31);
        contagemPalavras.adicionarPalavra("palavra 1", 2);
        contagemPalavras.adicionarPalavra("palavra 2", 10);
        contagemPalavras.adicionarPalavra("palavra 3", 22);
        contagemPalavras.adicionarPalavra("palavra 4", 5);

        contagemPalavras.exibirContagemPalavras();

        contagemPalavras.removerPalavra("palavra 2");
        contagemPalavras.exibirContagemPalavras();


        System.out.println("A palavra mais frequente é: " + contagemPalavras.encontrarPalavraMaisFrequente());
    }
}
