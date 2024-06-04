package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeroList;

    @Override
    public String toString() {
        return "SomaNumeros{" +
                "numeroList=" + numeroList +
                '}';
    }

    public SomaNumeros() {
        this.numeroList = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numeroList.add(numero);
    }

    public int calcularSoma(){
        if(numeroList.isEmpty()){
            return 0;
        }

        int totalSoma = 0;

        for (int numero : numeroList){
            totalSoma += numero;
        }

        return totalSoma;
    }

    public int encontrarMaiorNumero(){
        if(numeroList.isEmpty()){
            throw new RuntimeException("Lista vazia");
        }

        int maiorNumero = numeroList.get(0);

        for (int numero : numeroList){
            if(numero > maiorNumero){
                maiorNumero = numero;
            }
        }

        return maiorNumero;
    }

    public int encontrarMenorNumero(){
        if(numeroList.isEmpty()){
            throw new RuntimeException("Lista vazia");
        }

        int menorNumero = numeroList.get(0);

        for (int numero : numeroList){
            if(numero < menorNumero){
                menorNumero = numero;
            }
        }

        return menorNumero;
    }

    public void exibirNumeros(){
        System.out.println(numeroList);
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();
        somaNumeros.adicionarNumero(2);
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(6);
        somaNumeros.adicionarNumero(2);
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(-2);

        somaNumeros.exibirNumeros();

        System.out.println("A soma dos números é: " + somaNumeros.calcularSoma());
        System.out.println("O menor dos números é: " + somaNumeros.encontrarMenorNumero());
        System.out.println("O maior dos números é: " + somaNumeros.encontrarMaiorNumero());
    }
}
