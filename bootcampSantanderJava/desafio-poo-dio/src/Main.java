import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso("Curso java", "Descrição curso java", 8);
        Curso curso2 = new Curso("Curso js", "Descrição curso js", 4);

        Mentoria mentoria = new Mentoria("Mentoria de java", "Descrição mentoria java", LocalDate.now());

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");
        bootcamp.adicionaConteudo(curso1);
        bootcamp.adicionaConteudo(curso2);
        bootcamp.adicionaConteudo(mentoria);

        Dev devCamila = new Dev("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("XP:" + devJoao.calcularTotalXp());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());

    }

}