package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numeroList;

    public OrdenacaoNumeros() {
        this.numeroList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "OrdenacaoNumeros{" +
                "numeroList=" + numeroList +
                '}';
    }

    public void adicionarNumero(int numero){
        numeroList.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        if(numeroList.isEmpty()){
            throw new RuntimeException("Lista está vazia");
        }

        List<Integer> numerosAscendente = new ArrayList<>(numeroList);
        Collections.sort(numerosAscendente);
        return numerosAscendente;
    }

    public List<Integer> ordenarDescendente() {
        if(numeroList.isEmpty()){
            throw new RuntimeException("Lista está vazia");
        }

        List<Integer> numerosAscendente = new ArrayList<>(numeroList);
        numerosAscendente.sort(Collections.reverseOrder());
        return numerosAscendente;
    }

    public void exibirNumeros() {
        if(numeroList.isEmpty()){
            throw new RuntimeException("Lista está vazia");
        }

        System.out.println(numeroList);
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();
        numeros.adicionarNumero(4);
        numeros.adicionarNumero(8);
        numeros.adicionarNumero(2);
        numeros.adicionarNumero(1);
        numeros.adicionarNumero(5);
        numeros.adicionarNumero(87);
        numeros.exibirNumeros();
        System.out.println("Ordem ascendente: " + numeros.ordenarAscendente());
        System.out.println("Ordem descendente: " + numeros.ordenarDescendente());
    }

}
