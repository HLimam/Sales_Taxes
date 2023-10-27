package fr.technical.test.application;

import fr.technical.test.domain.Money;
import fr.technical.test.domain.Product;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReceiptPrinterTest {
    @Test
    void testPrintReceipt_quantity_equalToOne() {
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();

        Product book = new Product("book", new Money(new BigDecimal("12.49")), 1, false, true);
        Product musicCD = new Product("music CD", new Money(new BigDecimal("14.99")), 1, false, false);
        Product chocolateBar = new Product("chocolate bar", new Money(new BigDecimal("0.85")), 1, false, true);

        List<Product> products = Arrays.asList(book, musicCD, chocolateBar);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        receiptPrinter.printReceipt(products);

        assertThat(outContent.toString()).contains("1 book: 12,49");
        assertThat(outContent.toString()).contains("1 music CD: 16,49");
        assertThat(outContent.toString()).contains("1 chocolate bar: 0,85");
        assertThat(outContent.toString()).contains("Sales Taxes : 1,50");
        assertThat(outContent.toString()).contains("Total : 29,83");
    }

    @Test
    void testPrintReceipt_quantity_moreThanOne() {
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();

        Product book = new Product("book", new Money(new BigDecimal("12.49")), 3, false, true);
        Product musicCD = new Product("music CD", new Money(new BigDecimal("14.99")), 2, false, false);
        Product chocolateBar = new Product("chocolate bar", new Money(new BigDecimal("0.85")), 5, false, true);

        List<Product> products = Arrays.asList(book, musicCD, chocolateBar);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        receiptPrinter.printReceipt(products);

        assertThat(outContent.toString()).contains("3 book: 37,47");
        assertThat(outContent.toString()).contains("2 music CD: 32,98");
        assertThat(outContent.toString()).contains("5 chocolate bar: 4,25");
        assertThat(outContent.toString()).contains("Sales Taxes : 3,00");
        assertThat(outContent.toString()).contains("Total : 74,70");
    }
}