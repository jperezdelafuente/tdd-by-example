package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    void testMultiplicationDollar() {
        Money five = Money.createDollar(5);
        assertEquals(Money.createDollar(10), five.times(2));
        assertEquals(Money.createDollar(15), five.times(3));
    }

    @Test
    void testEqualityDollar() {
        assertEquals(Money.createDollar(5), Money.createDollar(5));
        assertNotEquals(Money.createDollar(5), Money.createDollar(8));
        assertNotEquals(Money.createDollar(5), Money.createFranc(5));
    }

    @Test
    void testMultiplicationFranc() {
        Money five = Money.createFranc(5);
        assertEquals(Money.createFranc(10), five.times(2));
        assertEquals(Money.createFranc(15), five.times(3));
    }

    @Test
    void testEqualityFranc() {
        assertEquals(Money.createFranc(5), Money.createFranc(5));
        assertNotEquals(Money.createFranc(5), Money.createFranc(8));
    }
}
