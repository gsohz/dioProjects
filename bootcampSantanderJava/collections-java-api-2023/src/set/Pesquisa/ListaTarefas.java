package set.Pesquisa;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        if(tarefaSet.isEmpty()){
            throw new RuntimeException("Lista está vazia");
        }

        Tarefa tarefaParaRemover = null;

        for (Tarefa t : tarefaSet){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                tarefaParaRemover = t;
                break;
            }
        }

        if(tarefaParaRemover == null){
            throw new RuntimeException("Tarefa não encontrada");
        }

        tarefaSet.remove(tarefaParaRemover);
    }

    public void exibirTarefas(){
        System.out.println(tarefaSet);
    }

    public int contarTarefas(){
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        if(tarefaSet.isEmpty()){
            throw new RuntimeException("Lista está vazia");
        }

        Set<Tarefa> tarefasConcluidas = new HashSet<>();

        for (Tarefa t : tarefaSet){
            if(t.isEstaConcluida()){
                tarefasConcluidas.add(t);
            }
        }

        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        if(tarefaSet.isEmpty()){
            throw new RuntimeException("Lista está vazia");
        }

        Set<Tarefa> tarefasPendentes = new HashSet<>();

        for (Tarefa t : tarefaSet){
            if(!t.isEstaConcluida()){
                tarefasPendentes.add(t);
            }
        }

        return tarefasPendentes;
    }

    public Tarefa pesquisaTarefa(String descricao){
        if(tarefaSet.isEmpty()){
            throw new RuntimeException("Lista está vazia");
        }

        Tarefa tarefaPesquisada = null;

        for (Tarefa t : tarefaSet){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                tarefaPesquisada = t;
                break;
            }
        }

        if(tarefaPesquisada == null){
            throw new RuntimeException("Tarefa não encontrada");
        }

        return tarefaPesquisada;
    }

    private Tarefa mudarEstadoTarefa(String descricao, boolean estado){
        if(tarefaSet.isEmpty()){
            throw new RuntimeException("Lista está vazia");
        }

        Tarefa tarefaParaAtualizar = null;

        for (Tarefa t : tarefaSet){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                t.setEstaConcluida(estado);
                tarefaParaAtualizar = t;
                break;
            }
        }

        if(tarefaParaAtualizar == null){
            throw new RuntimeException("Tarefa não encontrada");
        }

        return tarefaParaAtualizar;
    }

    public Tarefa marcarTarefaConcluida(String descricao){
        return mudarEstadoTarefa(descricao, true);
    }

    public Tarefa marcarTarefaPendente(String descricao){
        return mudarEstadoTarefa(descricao, false);
    }

    public void limparListaTarefas(){
        tarefaSet.clear();
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.exibirTarefas();

        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 2");
        listaTarefas.adicionarTarefa("Tarefa 2");
        listaTarefas.adicionarTarefa("Tarefa 3");
        listaTarefas.adicionarTarefa("Tarefa 4");

        listaTarefas.exibirTarefas();
        System.out.println("A quantidade de tarefas é: " + listaTarefas.contarTarefas());

        listaTarefas.removerTarefa("tarefa 4");
        listaTarefas.exibirTarefas();
        System.out.println("A quantidade de tarefas é: " + listaTarefas.contarTarefas());

        listaTarefas.marcarTarefaConcluida("tarefa 3");
        System.out.println("Pesquisa palavra 3: " + listaTarefas.pesquisaTarefa("tarefa 3"));

        System.out.println("Tarefas concluídas: " + listaTarefas.obterTarefasConcluidas());
        System.out.println("Tarefas pendentes: " + listaTarefas.obterTarefasPendentes());

        listaTarefas.marcarTarefaPendente("tarefa 3");
        System.out.println("Tarefas concluídas: " + listaTarefas.obterTarefasConcluidas());
        System.out.println("Tarefas pendentes: " + listaTarefas.obterTarefasPendentes());

        listaTarefas.limparListaTarefas();
        System.out.println("A quantidade de tarefas é: " + listaTarefas.contarTarefas());
    }

}
