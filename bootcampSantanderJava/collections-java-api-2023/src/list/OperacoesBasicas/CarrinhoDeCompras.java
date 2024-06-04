package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensParaRemoverList = new ArrayList<>();

        for (Item item : itemList){
            if(item.getNome().equalsIgnoreCase(nome)){
                itensParaRemoverList.add(item);
            }
        }

        itemList.removeAll(itensParaRemoverList);
    }

    public double calcularValorTotal(){
        double total = 0;

        for (Item item : itemList){
            total += item.getPreco();
        }

        return total;
    }

    public void exibirItens(){
        System.out.println(itemList);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Item 1", 23.3, 4);
        carrinhoDeCompras.adicionarItem("Item 2", 4.99, 1);

        System.out.println("O total do carrinho é: " + carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.adicionarItem("Item 3", 10, 1);

        carrinhoDeCompras.removerItem("Item 1");

        System.out.println("O total do carrinho é: " + carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.exibirItens();
    }

}
