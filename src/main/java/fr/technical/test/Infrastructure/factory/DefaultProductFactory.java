package fr.technical.test.Infrastructure.factory;

import fr.technical.test.domain.Product;
import fr.technical.test.domain.ProductBuilder;
import fr.technical.test.domain.ProductFactory;
import fr.technical.test.domain.TaxExemptProductService;

import java.math.BigDecimal;

public record DefaultProductFactory(TaxExemptProductService taxExemptProductService) implements ProductFactory {
    @Override
    public Product createProduct(String name, BigDecimal price, int quantity, boolean isImported) {
        var isTaxExempt = taxExemptProductService.getTaxExemptProducts().contains(name);

        if (isImported && isTaxExempt) {
            return ProductBuilder.anImportedTaxExemptProduct()
                    .name(name)
                    .price(price)
                    .quantity(quantity)
                    .build();
        } else if (isImported) {
            return ProductBuilder.anImportedProduct()
                    .name(name)
                    .price(price)
                    .quantity(quantity)
                    .build();
        } else if (isTaxExempt) {
            return ProductBuilder.aTaxExemptProduct()
                    .name(name)
                    .price(price)
                    .quantity(quantity)
                    .build();
        }else {
            return ProductBuilder.aProduct()
                    .name(name)
                    .price(price)
                    .quantity(quantity)
                    .build();
        }
    }
}