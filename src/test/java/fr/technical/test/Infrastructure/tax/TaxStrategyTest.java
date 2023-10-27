package fr.technical.test.Infrastructure.tax;

import fr.technical.test.domain.Money;
import fr.technical.test.domain.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaxStrategyTest {

    @Test
    public void testDetermineTaxForTaxExemptProduct() {
        Product book = new Product("book", new Money(BigDecimal.valueOf(12.49)),1, false, true);
        TaxStrategy taxStrategy = new TaxStrategy();

        assertTrue(taxStrategy.determineTax(book) instanceof NoTax);
    }

    @Test
    public void testDetermineTaxForImportedTaxExemptProduct() {
        Product importedChocolate = new Product("imported chocolate", new Money(BigDecimal.valueOf(10.00)),1, true, true);
        TaxStrategy taxStrategy = new TaxStrategy();

        assertTrue(taxStrategy.determineTax(importedChocolate) instanceof ImportDutyTax);
    }

    @Test
    public void testDetermineTaxForTaxableProduct() {
        Product musicCD = new Product("music CD", new Money(BigDecimal.valueOf(14.99)),1, false, false);
        TaxStrategy taxStrategy = new TaxStrategy();

        assertTrue(taxStrategy.determineTax(musicCD) instanceof BasicTax);
    }

    @Test
    public void testDetermineTaxForImportedTaxableProduct() {
        Product importedPerfume = new Product("imported perfume", new Money(BigDecimal.valueOf(27.99)),1, true, false);
        TaxStrategy taxStrategy = new TaxStrategy();

        assertTrue(taxStrategy.determineTax(importedPerfume) instanceof CombinedTax);
    }
}