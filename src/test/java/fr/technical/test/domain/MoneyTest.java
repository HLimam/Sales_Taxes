package fr.technical.test.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    void testAddition() {
        var money1 = new Money(new BigDecimal("10.00"));
        var money2 = new Money(new BigDecimal("15.50"));

        var result = money1.add(money2);

        assertThat(result.value()).isEqualByComparingTo(new BigDecimal("25.50"));
    }

    @Test
    void testMultiplication() {
        var money = new Money(new BigDecimal("10.00"));

        var result = money.multiply(new BigDecimal("0.10"));

        assertThat(result.value()).isEqualByComparingTo(new BigDecimal("1.00"));
    }
}