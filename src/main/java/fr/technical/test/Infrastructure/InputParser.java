package fr.technical.test.Infrastructure;

import fr.technical.test.domain.Product;
import fr.technical.test.domain.ProductFactory;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public record InputParser(ProductFactory productFactory) {
    private static final Pattern PATTERN = Pattern.compile("(\\d+) (.+) at (\\d+\\.\\d{2})");

    public Product parse(String input) {
        var matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            var quantity = Integer.parseInt(matcher.group(1));
            var name = matcher.group(2);
            var isImported = name.contains("imported");
            var amount = new BigDecimal(matcher.group(3));

            return productFactory.createProduct(name, amount, quantity, isImported);
        }
        throw new IllegalArgumentException("Invalid input format: " + input);
    }
}