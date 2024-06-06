package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if(agendaContatoMap.isEmpty()){
            throw new RuntimeException("Coleção está vazia");
        }

        agendaContatoMap.remove(nome);
    }

    public void exibirContatos(){
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome){
        if(agendaContatoMap.isEmpty()){
            throw new RuntimeException("Coleção está vazia");
        }

        Integer numeroPorNome = agendaContatoMap.get(nome);

        if(numeroPorNome == null){
            throw new RuntimeException("Nome não cadastrado");
        }

        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();
        agendaContatos.adicionarContato("Gabriel", 123456);
        agendaContatos.adicionarContato("Gabriel", 5665);
        agendaContatos.adicionarContato("Gabriel Ferreira", 11111111);
        agendaContatos.adicionarContato("Gabriel DIO", 6564987);
        agendaContatos.adicionarContato("Lissa Souza", 11111111);
        agendaContatos.adicionarContato("Gabriel", 44444);

        agendaContatos.exibirContatos();

        agendaContatos.removerContato("Gabriel");
        agendaContatos.exibirContatos();

        System.out.println("O número de Lissa Souza é: " +
                agendaContatos.pesquisarPorNome("Lissa Souza"));
    }
}
