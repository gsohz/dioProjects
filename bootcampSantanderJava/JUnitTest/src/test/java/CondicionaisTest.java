import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;

public class CondicionaisTest {
    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    void validarAlgoSomenteNoUsuarioWillyan() {
        Assertions.assertEquals(10, 5 + 5);
    }
}
