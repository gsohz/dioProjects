package set.Pesquisa;

import java.util.Objects;

public class Tarefa {
    private String descricao;
    private boolean estaConcluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.estaConcluida = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa tarefa)) return false;
        return Objects.equals(getDescricao(), tarefa.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDescricao());
    }

    public Tarefa(String descricao, boolean estaConcluida) {
        this.descricao = descricao;
        this.estaConcluida = estaConcluida;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isEstaConcluida() {
        return estaConcluida;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEstaConcluida(boolean estaConcluida) {
        this.estaConcluida = estaConcluida;
    }

    @Override
    public String toString() {
        return "{" +
                    descricao + ", " +
                    estaConcluida +
                '}';
    }
}
