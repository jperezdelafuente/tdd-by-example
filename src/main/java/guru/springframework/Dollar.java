package guru.springframework;

import java.util.Objects;

public class Dollar extends Money {

    public Dollar(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    public Money times(int multiplier) {
        return Money.createDollar(amount * multiplier);
    }

}
