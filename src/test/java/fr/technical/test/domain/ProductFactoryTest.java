package fr.technical.test.domain;

import fr.technical.test.Infrastructure.factory.DefaultProductFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class ProductFactoryTest {
    private TaxExemptProductService taxExemptProductService;
    private DefaultProductFactory factory;

    @BeforeEach
    public void setUp() {
        taxExemptProductService = mock(TaxExemptProductService.class);
        factory = new DefaultProductFactory(taxExemptProductService);
    }

    @Test
    public void testCreateTaxExemptProduct() {
        when(taxExemptProductService.getTaxExemptProducts()).thenReturn(Arrays.asList("book"));

        Product product = factory.createProduct("book", new BigDecimal("12.49"), 1, false);

        assertTrue(product.isTaxExempt());
        assertFalse(product.isImported());
        assertEquals(new BigDecimal("12.49"), product.price().value());
    }

    @Test
    public void testCreateImportedProduct() {
        when(taxExemptProductService.getTaxExemptProducts()).thenReturn(Arrays.asList());

        Product product = factory.createProduct("imported perfume", new BigDecimal("20.99"), 1, true);

        assertFalse(product.isTaxExempt());
        assertTrue(product.isImported());
        assertEquals(new BigDecimal("20.99"), product.price().value());
    }

    @Test
    public void testCreateImportedTaxExemptProduct() {
        when(taxExemptProductService.getTaxExemptProducts()).thenReturn(Arrays.asList("imported book"));

        Product product = factory.createProduct("imported book", new BigDecimal("10.99"), 2, true);

        assertTrue(product.isTaxExempt());
        assertTrue(product.isImported());
        assertEquals(new BigDecimal("10.99"), product.price().value());
        assertEquals(2, product.quantity());
    }

    @Test
    public void testCreateRegularProduct() {
        when(taxExemptProductService.getTaxExemptProducts()).thenReturn(Arrays.asList());

        Product product = factory.createProduct("music CD", new BigDecimal("14.99"), 1, false);

        assertFalse(product.isTaxExempt());
        assertFalse(product.isImported());
        assertEquals(new BigDecimal("14.99"), product.price().value());
    }
}
