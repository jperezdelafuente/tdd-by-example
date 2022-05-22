package guru.springframework;

public abstract class Money {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency() {
        return currency;
    }

    public abstract Money times(int multiplier);

    public static Money createDollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money createFranc(int amount) {
        return new Franc(amount, "CHF");
    }

    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount &&
                getClass().equals(object.getClass());
    }
}
