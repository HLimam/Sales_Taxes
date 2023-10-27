package fr.technical.test.Infrastructure.tax;

import fr.technical.test.domain.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class BasicTaxTest {

    @Test
    void testBasicTaxCalculation() {
        var tax = new BasicTax();
        var result = tax.calculate(new Money(BigDecimal.valueOf(10.00)));

        assertThat(result.value()).isEqualByComparingTo("1.00");
    }
}