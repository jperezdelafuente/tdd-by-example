package guru.springframework;

public class Money {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency() {
        return currency;
    }

    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    public static Money createDollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money createFranc(int amount) {
        return new Franc(amount, "CHF");
    }

    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount &&
                this.currency == money.currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
