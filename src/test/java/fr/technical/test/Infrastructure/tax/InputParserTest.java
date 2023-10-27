package fr.technical.test.Infrastructure.tax;

import fr.technical.test.Infrastructure.InputParser;
import fr.technical.test.domain.Money;
import fr.technical.test.domain.Product;
import fr.technical.test.domain.ProductFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class InputParserTest {
    private ProductFactory productFactory;
    private InputParser inputParser;

    @BeforeEach
    public void setup() {
        productFactory = mock(ProductFactory.class);
        inputParser = new InputParser(productFactory);
    }

    @Test
    public void testParseValidInput() {
        var input = "1 book at 12.49";
        var mockProduct = new Product("book", new Money(new BigDecimal("12.49")), 1, false, true);
        when(productFactory.createProduct("book", new BigDecimal("12.49"), 1, false)).thenReturn(mockProduct);
        var result = inputParser.parse(input);
        assertEquals(mockProduct, result);
    }

    @Test
    public void testParseInputWithImportedProduct() {
        var input = "1 imported box of chocolates at 10.00";
        var mockProduct = new Product("imported box of chocolates", new Money(new BigDecimal("10.00")), 1, true, false);
        when(productFactory.createProduct("imported box of chocolates", new BigDecimal("10.00"), 1, true)).thenReturn(mockProduct);
        var result = inputParser.parse(input);
        assertEquals(mockProduct, result);
    }

    @Test
    public void testParseInvalidInput() {
        var invalidInput = "invalid string";
        assertThrows(IllegalArgumentException.class, () -> inputParser.parse(invalidInput));
    }

}
