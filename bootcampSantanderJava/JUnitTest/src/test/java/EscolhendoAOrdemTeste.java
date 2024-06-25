import org.junit.jupiter.api.*;

//Valida pelo nome de anotacao
@TestMethodOrder(MethodOrderer.DisplayName.class)

//Valida aleatoriamente
//@TestMethodOrder(MethodOrderer.Random.class)

//Valida pelo nome do metodo
//@TestMethodOrder(MethodOrderer.MethodName.class)

//Valida pela ordem de anotacao
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EscolhendoAOrdemTeste {

    //@Order(4)
    @DisplayName("Teste que valida se o usuário foi criado")
    @Test
    void validaFluxoA() {
        Assertions.assertTrue(true);
    }

    //@Order(3)
    @DisplayName("B")
    @Test
    void validaFluxoB() {
        Assertions.assertTrue(true);
    }

    //@Order(2)
    @DisplayName("C")
    @Test
    void validaFluxoC() {
        Assertions.assertTrue(true);
    }

    //@Order(1)
    @DisplayName("D")
    @Test
    void validaFluxoD() {
        Assertions.assertTrue(true);
    }
}