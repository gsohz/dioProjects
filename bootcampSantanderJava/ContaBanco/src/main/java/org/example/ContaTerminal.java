package org.example;

import java.text.MessageFormat;

public class ContaTerminal {
    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    public ContaTerminal(int numero, String agencia, String nomeCliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public void exibeDados(){
        String dados = MessageFormat
                .format("Olá {0}, obrigado por criar uma conta em nosso banco," +
                        " sua agência é {1}, conta {2} e seu saldo {3}" +
                        " já está disponível para saque", this.nomeCliente, this.agencia, this.numero, this.saldo);
        System.out.println(dados);
    }
}
