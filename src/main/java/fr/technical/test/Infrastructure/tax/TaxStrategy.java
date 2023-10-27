package fr.technical.test.Infrastructure.tax;

import fr.technical.test.domain.Product;
import fr.technical.test.domain.Tax;

public class TaxStrategy {
    public Tax determineTax(Product product) {
        if (product.isTaxExempt()) {
            if (product.isImported()) {
                return new ImportDutyTax();
            } else {
                return new NoTax();
            }
        } else {
            if (product.isImported()) {
                return new CombinedTax(new BasicTax(),new ImportDutyTax());
            } else {
                return new BasicTax();
            }
        }
    }
}
