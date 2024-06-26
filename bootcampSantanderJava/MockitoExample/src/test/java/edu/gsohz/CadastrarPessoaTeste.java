package edu.gsohz;

import static org.junit.jupiter.api.Assertions.*;

import edu.gsohz.pessoa.ApiDosCorreios;
import edu.gsohz.pessoa.CadastrarPessoa;
import edu.gsohz.pessoa.DadosLocalizacao;
import edu.gsohz.pessoa.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;
    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro(){
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG", "Patos de Minas", "Rua 2", "Apto", "Centro");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("1123132")).thenReturn(dadosLocalizacao);
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Gabriel", "32342432", LocalDate.now(), "1123132");

        assertEquals("Gabriel", pessoa.getNome());
        assertEquals("32342432", pessoa.getDocumento());
        assertEquals("MG", pessoa.getEndereco().getUf());
        assertEquals("Apto", pessoa.getEndereco().getComplemento());
    }

    @Test
    void lancarExceptionQuandoChamarApiDosCorreios(){
        /*
        Mockito.doThrow(IllegalAccessError.class)
                                .when(apiDosCorreios)
                                        .buscaDadosComBaseNoCep(Mockito.anyString());
         */


        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("1123132")).thenThrow(IllegalArgumentException.class);

        Assertions.assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.cadastrarPessoa("Gabriel", "32342432", LocalDate.now(), "1123132"));
    }

    @Test
    void cadastrarPessoa() {

        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG", "Uberaba", "Rua Castro Alves", "Casa", "Nova Floresta");

        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(Mockito.anyString())).thenReturn(dadosLocalizacao);

        Pessoa jose = cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300");

        DadosLocalizacao enderecoJose = jose.getEndereco();
        assertEquals(dadosLocalizacao.getBairro(), enderecoJose.getBairro());
        assertEquals(dadosLocalizacao.getCidade(), enderecoJose.getCidade());
        assertEquals(dadosLocalizacao.getUf(), enderecoJose.getUf());
    }

    @Test
    void tentaCadastrarPessoaMasSistemaDosCorreiosFalha() {

        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(Mockito.anyString())).thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () -> cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300"));
    }
}
