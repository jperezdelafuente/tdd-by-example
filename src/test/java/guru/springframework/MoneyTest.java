package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    void testMultiplication() {
        Money five = Money.createDollar(5);
        assertEquals(Money.createDollar(10), five.times(2));
        assertEquals(Money.createDollar(15), five.times(3));

        Money fiveF = Money.createFranc(5);
        assertEquals(Money.createFranc(10), fiveF.times(2));
        assertEquals(Money.createFranc(15), fiveF.times(3));
    }

    @Test
    void testEquality() {
        assertEquals(Money.createDollar(5), Money.createDollar(5));
        assertNotEquals(Money.createDollar(5), Money.createDollar(8));

        assertEquals(Money.createFranc(5), Money.createFranc(5));
        assertNotEquals(Money.createFranc(5), Money.createFranc(8));

        assertNotEquals(Money.createDollar(5), Money.createFranc(5));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.createDollar(1).currency());
        assertEquals("CHF", Money.createFranc(1).currency());
    }
}
