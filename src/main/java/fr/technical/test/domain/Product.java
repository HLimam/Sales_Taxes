package fr.technical.test.domain;

public record Product(String name, Money price, int quantity, boolean isImported, boolean isTaxExempt) {
}
