package edu.gsohz;

import lombok.Getter;

@Getter
public class Cliente {
    private static int SEQUENCIAL = 1;

    private int id;
    private String nome;

    Cliente(String nome){
        this.id = SEQUENCIAL++;
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome +
                '}';
    }
}