package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, digite o numero da conta:");
        int numero = scanner.nextInt();
        scanner.nextLine(); //limpa 'enter' do buffer gerado pela leitura do numero com nextInt

        System.out.println("Por favor, digite o numero da agencia:");
        String agencia = scanner.nextLine();

        System.out.println("Por favor, digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Por favor, digite o saldo:");
        double saldo = scanner.nextDouble();

        ContaTerminal conta = new ContaTerminal(numero, agencia, nomeCliente, saldo);
        conta.exibeDados();
    }
}