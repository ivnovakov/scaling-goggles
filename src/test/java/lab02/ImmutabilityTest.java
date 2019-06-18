package lab02;

import lab02.individual.IDate;
import lab02.individual.Timestamp;
import lab02.proxy.DateImmutabilityProxy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ImmutabilityTest {
    private IDate timestamp;

    @BeforeAll
    void setUp() {
        timestamp = new DateImmutabilityProxy(
                new Timestamp(2019, 11, 285, 12, 21)
        );
    }

    @Test
    void testSetters() {
        Assertions.assertThrows(RuntimeException.class, () -> timestamp.setYear(2019));
        Assertions.assertThrows(RuntimeException.class, () -> timestamp.setMonth(6));
        Assertions.assertThrows(RuntimeException.class, () -> timestamp.setDay(18));
        }

    @Test
    void testGetters() {
        Assertions.assertDoesNotThrow(() -> timestamp.getYear());
        Assertions.assertDoesNotThrow(() -> timestamp.getMonth());
        Assertions.assertDoesNotThrow(() -> timestamp.getDay());
    }
}
