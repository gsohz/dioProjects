package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double media){
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula){
        if(alunoSet.isEmpty()){
            throw new RuntimeException("Conjunto está vazio");
        }

        Aluno alunoParaRemover = null;

        for (Aluno a : alunoSet){
            if (Long.compare(a.getMatricula(), matricula) == 0){
                alunoParaRemover = a;
                break;
            }
        }

        if(alunoParaRemover == null){
            throw new RuntimeException("Aluno não encontrado");
        }

        alunoSet.remove(alunoParaRemover);
    }

    public Set<Aluno> exibirAlunosPorNome(){
        if(alunoSet.isEmpty()){
            throw new RuntimeException("Conjunto está vazio");
        }

        return new TreeSet<>(alunoSet);
    }

    public Set<Aluno> exibirAlunosPorNota(){
        if(alunoSet.isEmpty()){
            throw new RuntimeException("Conjunto está vazio");
        }

        Set<Aluno> alunoPorNota = new TreeSet<>(new ComparatorPorNota());
        alunoPorNota.addAll(alunoSet);

        return alunoPorNota;
    }

    public void exibirAlunos(){
        System.out.println(alunoSet);
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.exibirAlunos();

        gerenciadorAlunos.adicionarAluno("Gabriel Ferreira", 1234L, 8.6);
        gerenciadorAlunos.adicionarAluno("Gabriel", 1234L, 6.6);
        gerenciadorAlunos.adicionarAluno("Carlos Eduardo", 1235L, 3.4);
        gerenciadorAlunos.adicionarAluno("Giovanna", 1236L, 7.8);
        gerenciadorAlunos.adicionarAluno("Carlos Alves", 1237L, 9.9);
        gerenciadorAlunos.adicionarAluno("Guilherme Ferreira", 1238L, 8.6);

        gerenciadorAlunos.exibirAlunos();

        gerenciadorAlunos.removerAluno(1238L);

        gerenciadorAlunos.exibirAlunos();

        System.out.println("Alunos por nome: " + gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println("Alunos por nota: " + gerenciadorAlunos.exibirAlunosPorNota());
    }
}
