package fr.technical.test.domain;

import java.math.BigDecimal;

public record Money(BigDecimal value) {
    public static final Money ZERO = new Money(BigDecimal.ZERO);

    public Money add(Money other) {
        return new Money(value.add(other.value()));
    }

    public Money multiply(BigDecimal factor) {
        return new Money(value.multiply(factor));
    }
}
