package fr.technical.test.domain;

import java.math.BigDecimal;

public interface ProductFactory {
    Product createProduct(String name, BigDecimal price, int quantity, boolean isImported);
}
