package fr.technical.test;

import fr.technical.test.Infrastructure.InputParser;
import fr.technical.test.Infrastructure.factory.DefaultProductFactory;
import fr.technical.test.Infrastructure.tax.StubTaxExemptProductService;
import fr.technical.test.application.ReceiptPrinter;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var taxExemptProductService = new StubTaxExemptProductService();
        var productFactory = new DefaultProductFactory(taxExemptProductService);
        var inputParser = new InputParser(productFactory);
        var receiptPrinter = new ReceiptPrinter();

        // Input 1
        System.out.println("Basket 1:");
        var input1 = List.of(
                "1 book at 12.49",
                "1 music CD at 14.99",
                "1 chocolate bar at 0.85"
        );
        var basket1 = input1.stream()
                .map(inputParser::parse)
                .collect(Collectors.toList());

        receiptPrinter.printReceipt(basket1);
        // Input 2
        System.out.println("\nBasket 2:");
        var input2 = List.of(
                "1 imported box of chocolates at 10.00",
                "1 imported bottle of perfume at 47.50"
        );
        var basket2 = input2.stream()
                .map(inputParser::parse)
                .collect(Collectors.toList());

        receiptPrinter.printReceipt(basket2);

        // Input 3
        System.out.println("\nBasket 3:");
        var input3 = List.of(
                "1 imported bottle of perfume at 27.99",
                "1 bottle of perfume at 18.99",
                "1 packet of headache pills at 9.75",
                "1 box of imported chocolates at 11.25"
        );
        var basket3 = input3.stream()
                .map(inputParser::parse)
                .collect(Collectors.toList());

        receiptPrinter.printReceipt(basket3);

    }
}