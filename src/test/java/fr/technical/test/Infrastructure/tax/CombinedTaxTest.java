package fr.technical.test.Infrastructure.tax;

import fr.technical.test.domain.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CombinedTaxTest {

    @Test
    void testCombinedTaxCalculation() {
        var basicTax = new BasicTax();
        var importTax = new ImportDutyTax();
        var combinedTax = new CombinedTax(basicTax, importTax);

        var result = combinedTax.calculate(new Money(BigDecimal.valueOf(10.00)));

        assertThat(result.value()).isEqualByComparingTo("1.50");
    }
}