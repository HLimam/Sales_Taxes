package fr.technical.test.domain;

import java.math.BigDecimal;

public enum Rate {
    BASIC(new BigDecimal("0.10")),
    IMPORT(new BigDecimal("0.05")),
    NONE(BigDecimal.ZERO);

    private final BigDecimal value;

    Rate(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
