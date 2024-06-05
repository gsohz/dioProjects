package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasSet;

    @Override
    public String toString() {
        return "ConjuntoPalavrasUnicas{" +
                "palavrasSet=" + palavrasSet +
                '}';
    }

    public ConjuntoPalavrasUnicas() {
        this.palavrasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavrasSet.add(palavra);
    }

    public void removerPalavra(String palavra){
        if(palavrasSet.isEmpty()){
            throw new RuntimeException("Set está vazio");
        }

        String palavraParaRemover = null;

        for (String p : palavrasSet){
            if(p.equalsIgnoreCase(palavra)){
                palavraParaRemover = p;
                break;
            }
        }

        if(palavraParaRemover == null){
            throw new RuntimeException("Palavra não encontrada no conjunto");
        }

        palavrasSet.remove(palavraParaRemover);
    }

    public boolean verificarPalavra(String palavra){
        return palavrasSet.contains(palavra);
    }

    public void exibirPalavrasUnicas(){
        System.out.println(palavrasSet);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("palavra 1");
        conjuntoPalavrasUnicas.adicionarPalavra("palavra 2");
        conjuntoPalavrasUnicas.adicionarPalavra("palavra 3");
        conjuntoPalavrasUnicas.adicionarPalavra("palavra 3");
        conjuntoPalavrasUnicas.adicionarPalavra("palavra 4");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        System.out.println("\"palavra 4\" está no conjunto? " +
                (conjuntoPalavrasUnicas.verificarPalavra("palavra 4") ? "Sim" : "Não"));

        conjuntoPalavrasUnicas.removerPalavra("palavra 4");

        System.out.println("\"palavra 4\" está no conjunto? " +
                (conjuntoPalavrasUnicas.verificarPalavra("palavra 4") ? "Sim" : "Não"));
    }
}
