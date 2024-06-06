package map.Pesquisa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EstoqueProdutos {
    private HashMap<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque(){
        double valorTotalEstoque = 0;
        if(estoqueProdutosMap.isEmpty()){
            return valorTotalEstoque;
        }

        for (Produto p : estoqueProdutosMap.values()){
            valorTotalEstoque += p.getPreco() * p.getQuantidade();
        }

        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro(){
        if(estoqueProdutosMap.isEmpty()){
            throw new RuntimeException("Estoque está vazio");
        }

        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        for (Produto p : estoqueProdutosMap.values()){
            if(p.getPreco() > maiorPreco){
                produtoMaisCaro = p;
                maiorPreco = p.getPreco();
            }
        }

        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato(){
        if(estoqueProdutosMap.isEmpty()){
            throw new RuntimeException("Estoque está vazio");
        }


        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;

        for (Produto p : estoqueProdutosMap.values()) {
            if (p.getPreco() < menorPreco) {
                produtoMaisBarato = p;
                menorPreco = p.getPreco();
            }
        }

        return produtoMaisBarato;

    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        if(estoqueProdutosMap.isEmpty()){
            throw new RuntimeException("Estoque está vazio");
        }

        Produto produtoMaiorQuantidadeValorNoEstoque = null;
        double maiorValorTotalProdutoEstoque = 0d;

        for (Map.Entry<Long, Produto> entry : estoqueProdutosMap.entrySet()) {
            double valorProdutoEmEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();
            if (valorProdutoEmEstoque > maiorValorTotalProdutoEstoque) {
                maiorValorTotalProdutoEstoque = valorProdutoEmEstoque;
                produtoMaiorQuantidadeValorNoEstoque = entry.getValue();
            }
        }

        return produtoMaiorQuantidadeValorNoEstoque;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.exibirProdutos();
        estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
        estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
        estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
        estoque.adicionarProduto(4L, "Teclado", 2, 40.0);
        estoque.exibirProdutos();
        System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());
        Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("Produto mais caro: " + produtoMaisCaro);
        Produto produtoMaisBarato = estoque.obterProdutoMaisBarato();
        System.out.println("Produto mais barato: " + produtoMaisBarato);
        Produto produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("Produto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);
    }
}
