package edu.gsohz.models;

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {

    public void ligar(String numero) {
        System.out.println("Ligando para " + numero);
    }

    public void atender() {
        System.out.println("Chamada atendida");
    }

    public void iniciarCorreioVoz() {
        System.out.println("Reproduzindo correio de voz");
    }

    public void exibirPagina(String url) {
        System.out.println("Mostrando pagina da web " + url);
    }

    public void adicionarNovaAba() {
        System.out.println("Nova aba foi aberta");
    }

    public void atualizarPagina() {
        System.out.println("Pagina foi atualizada");
    }

    public void tocar() {
        System.out.println("Reproduzindo musica");
    }

    public void pausar() {
        System.out.println("Musica pausada");
    }

    public void selecionarMusica(String musica) {
        System.out.println("Musica " + musica + " inicida");
    }
}
