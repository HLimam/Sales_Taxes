package fr.technical.test.application;

import fr.technical.test.Infrastructure.tax.TaxStrategy;
import fr.technical.test.domain.Money;
import fr.technical.test.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public record ReceiptPrinter() {
    public void printReceipt(List<Product> products) {
        TaxStrategy taxStrategy = new TaxStrategy();

        Money totalTax = products.stream()
                .map(product -> taxStrategy.determineTax(product).calculate(product.price().multiply(BigDecimal.valueOf(product.quantity()))))
                .reduce(Money.ZERO, Money::add);

        Money totalAmount = products.stream()
                .map(product -> product.price().multiply(BigDecimal.valueOf(product.quantity())).add(taxStrategy.determineTax(product).calculate(product.price().multiply(BigDecimal.valueOf(product.quantity())))))
                .reduce(Money.ZERO, Money::add);

        products.forEach(product -> {
            Money totalProductPrice = product.price().multiply(BigDecimal.valueOf(product.quantity()));
            Money taxedPrice = totalProductPrice.add(taxStrategy.determineTax(product).calculate(totalProductPrice));
            System.out.printf("%d %s: %.2f%n", product.quantity(), product.name(), taxedPrice.value());
        });

        System.out.printf("Sales Taxes : %.2f Total : %.2f%n", totalTax.value(), totalAmount.value());
    }

}
