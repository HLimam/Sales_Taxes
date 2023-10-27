package fr.technical.test.Infrastructure.tax;

import fr.technical.test.domain.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ImportDutyTaxTest {

    @Test
    void testImportDutyTaxCalculation() {
        var tax = new ImportDutyTax();
        var result = tax.calculate(new Money(BigDecimal.valueOf(10.00)));

        assertThat(result.value()).isEqualByComparingTo("0.50");
    }
}