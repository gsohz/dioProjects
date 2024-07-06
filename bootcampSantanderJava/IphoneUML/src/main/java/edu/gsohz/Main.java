package edu.gsohz;

import edu.gsohz.models.Iphone;

public class Main {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();

        iphone.ligar("12343242");
        iphone.atender();
        iphone.iniciarCorreioVoz();

        iphone.adicionarNovaAba();
        iphone.exibirPagina("dio.me");
        iphone.atualizarPagina();

        iphone.selecionarMusica("Routines In The Night - Twenty One Pilots");
        iphone.pausar();
        iphone.tocar();

    }
}