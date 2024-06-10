package edu.gsohz;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Banco {

    private String nome;
    private List<Conta> contas;

    Banco(String nome){
        this.nome = nome;
        this.contas = new ArrayList<>();
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
        System.out.println("Nome do banco: " + getNome());
        System.out.println("Lista de clientes:" + getClientes());
        System.out.println("Saldo no banco: " + getSaldoTotalBanco());
    }

}
