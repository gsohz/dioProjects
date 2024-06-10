package edu.gsohz;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("DioBank");
        Cliente gabriel = new Cliente("Gabriel");
        Cliente lissa = new Cliente("Lissa");

        Conta ccGabriel = new ContaCorrente(banco, gabriel);
        Conta poupancaGabriel = new ContaPoupanca(banco, gabriel);
        Conta ccLissa = new ContaCorrente(banco, lissa);

        ccGabriel.depositar(100);
        ccGabriel.transferir(25, poupancaGabriel);
        ccLissa.depositar(1000);
        ccLissa.sacar(10);

        ccLissa.imprimirExtrato();
        ccGabriel.imprimirExtrato();
        poupancaGabriel.imprimirExtrato();
        banco.imprimirInfomacoesBanco();

    }
}
