package edu.gsohz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {

    private String nome;
    private List<Conta> contas;

    Banco(){
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionaConta(Conta conta) {
        this.contas.add(conta);
    }

    public List<Cliente> getClientes(){
        return contas.stream()
                .map(Conta::getCliente)
                .distinct()
                .collect(Collectors.toList());
    }

    public double getSaldoTotalBanco(){
        return contas.stream().mapToDouble(Conta::getSaldo).sum();
    }

    public void imprimirInfomacoesBanco(){
        System.out.println("=== Infos Banco ===");
        System.out.println("Lista de clientes:" + getClientes());
        System.out.println("Saldo no banco: " + getSaldoTotalBanco());
    }

}
