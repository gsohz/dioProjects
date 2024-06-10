package edu.gsohz;

public class Cliente {
    private static int SEQUENCIAL = 1;

    private int id;
    private String nome;

    Cliente(String nome){
        this.id = SEQUENCIAL++;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome +
                '}';
    }
}