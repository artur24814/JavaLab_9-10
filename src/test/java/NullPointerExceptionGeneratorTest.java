import org.junit.jupiter.api.Test;
import exceptionsGen.NullPointerExceptionGenerator;

import static org.junit.jupiter.api.Assertions.*;

public class NullPointerExceptionGeneratorTest {
    @Test
    public void  testRaiseNullPointerException (){
        assertThrows(NullPointerException.class, () -> NullPointerExceptionGenerator.raiseNullPointerException());
    }
}
