package edu.gsohz;

import edu.gsohz.email.Email;
import edu.gsohz.email.Formato;
import edu.gsohz.email.PlataformaDeEnvio;
import edu.gsohz.email.ServicoEnvioEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTeste {
    @Mock
    private PlataformaDeEnvio plataforma;
    @InjectMocks
    private ServicoEnvioEmail servico;

    @Captor
    private ArgumentCaptor<Email> captor;

    @Test
    void validarDadosEnviadosParaPlataforma(){
        String enderecoDeEmail = "usuario@test.com";
        String mensagem = "Ola mundo teste mensagem";
        boolean ehFormatoHtml = false;

        servico.enviaEmail(enderecoDeEmail, mensagem, ehFormatoHtml);

        Mockito.verify(plataforma).enviaEmail(captor.capture());

        Email emailCapturado = captor.getValue();

        Assertions.assertEquals(enderecoDeEmail, emailCapturado.getEnderecoEmail());
        Assertions.assertEquals(mensagem, emailCapturado.getMensagem());
        Assertions.assertEquals(Formato.TEXTO, emailCapturado.getFormato());
    }
}
