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

    @Test
    void testSimplyAddition() {
        Money five = Money.createDollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.createDollar(10), reduced);
    }

    @Test
    void testPlusReturnsSum() {
        Money five = Money.createDollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.createDollar(1), "USD");
        assertEquals(Money.createDollar(1), result);
    }

    @Test
    void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.createFranc(2), "USD");
        assertEquals(Money.createDollar(1), result);
    }

    @Test
    void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
        assertEquals(1, new Bank().rate("CHF", "CHF"));
    }

    @Test
    void testMixedAddition() {
        Expression fiveDollars = Money.createDollar(5);
        Expression tenFrancs = Money.createFranc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveDollars.plus(tenFrancs), "USD");
        assertEquals(Money.createDollar(10), result);
    }

    @Test
    void testSumPlusMoney() {
        Expression fiveDollars = Money.createDollar(5);
        Expression tenFrancs = Money.createFranc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveDollars, tenFrancs).plus(fiveDollars);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.createDollar(15), result);
    }

    @Test
    void testSumTimes() {
        Expression fiveDollars = Money.createDollar(5);
        Expression tenFrancs = Money.createFranc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveDollars, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.createDollar(20), result);
    }
}



