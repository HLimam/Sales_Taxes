package fr.technical.test.domain;

import java.math.BigDecimal;

public class ProductBuilder {
    private String name;
    private Money price;
    private int quantity;
    private boolean isImported = false;
    private boolean isTaxExempt = false;

    private ProductBuilder() {}

    public static ProductBuilder aProduct() {
        return new ProductBuilder();
    }

    public static ProductBuilder anImportedProduct() {
        return new ProductBuilder().imported();
    }

    public static ProductBuilder aTaxExemptProduct() {
        return new ProductBuilder().taxExempt();
    }

    public static ProductBuilder anImportedTaxExemptProduct() {
        return new ProductBuilder().imported().taxExempt();
    }
    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder price(BigDecimal price) {
        this.price = new Money(price);
        return this;
    }

    public ProductBuilder quantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    private ProductBuilder imported() {
        this.isImported = true;
        return this;
    }

    private ProductBuilder taxExempt() {
        this.isTaxExempt = true;
        return this;
    }

    public Product build() {
        return new Product(name, price, quantity, isImported, isTaxExempt);
    }

}
