package edu.gsohz;

public class ContaCorrente extends Conta {

    public ContaCorrente(Banco banco, Cliente cliente) {
        super(banco, cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

}