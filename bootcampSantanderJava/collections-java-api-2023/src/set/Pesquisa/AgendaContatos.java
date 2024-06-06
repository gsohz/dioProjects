package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContato(){
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        if(contatoSet.isEmpty()){
            throw new RuntimeException("Set está vazio");
        }

        Set<Contato> contatosPorNome = new HashSet<>();

        for (Contato c : contatoSet){
            if(c.getNome().startsWith(nome)){
                contatosPorNome.add(c);
            }
        }

        if(contatosPorNome.isEmpty()){
            throw new RuntimeException("Contato não registrado");
        }

        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        if(contatoSet.isEmpty()){
            throw new RuntimeException("Set está vazio");
        }

        Contato contatoAtualizado = null;

        for(Contato c : contatoSet){
            if(c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }

        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContato();

        agendaContatos.adicionarContato("Gabriel", 123456);
        agendaContatos.adicionarContato("Gabriel", 0);
        agendaContatos.adicionarContato("Gabriel Ferreira", 123456);
        agendaContatos.adicionarContato("Gabriel DIO", 654321);
        agendaContatos.adicionarContato("Paulo", 1111111);

        agendaContatos.exibirContato();

        System.out.println("Pesquisa por Gabriel: " + agendaContatos.pesquisarPorNome("Gabriel"));

        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Paulo", 67890));

        agendaContatos.exibirContato();
    }
}
