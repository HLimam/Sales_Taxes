package fr.technical.test.Infrastructure.tax;

import fr.technical.test.domain.Money;
import fr.technical.test.domain.Tax;

import java.math.BigDecimal;

public class NoTax implements Tax {
    @Override
    public Money calculate(Money price) {
        return new Money(BigDecimal.ZERO);
    }
}