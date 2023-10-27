package fr.technical.test.Infrastructure.tax;

import fr.technical.test.domain.Money;
import fr.technical.test.domain.Tax;

public record CombinedTax(Tax firstTax,Tax secondTax) implements Tax {

    @Override
    public Money calculate(Money price) {
        return firstTax.calculate(price).add(secondTax.calculate(price));
    }
}