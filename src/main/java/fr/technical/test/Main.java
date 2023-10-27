package fr.technical.test;

import fr.technical.test.Infrastructure.factory.DefaultProductFactory;
import fr.technical.test.Infrastructure.tax.StubTaxExemptProductService;
import fr.technical.test.application.ReceiptPrinter;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var taxExemptProductService = new StubTaxExemptProductService();
        var productFactory = new DefaultProductFactory(taxExemptProductService);
        var receiptPrinter = new ReceiptPrinter();

        var basket1 = List.of(
                productFactory.createProduct("book", new BigDecimal("12.49"), 1,false),
                productFactory.createProduct("music CD", new BigDecimal("14.99"), 1,false),
                productFactory.createProduct("chocolate bar", new BigDecimal("0.85"), 1,false)
        );


        receiptPrinter.printReceipt(basket1);
    }
}