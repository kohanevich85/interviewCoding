package com.terminal;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by denis.
 */
public class TerminalTest {

    @Test
    public void testTerminalWithoutDiscounts() {

        Terminal terminal = new TerminalImpl();
        terminal.addProducts('A', 'B', 'C', 'D');
        BigDecimal result = terminal.calculateTotal();
        Assert.assertTrue(result.floatValue() == 7.25);
    }

    @Test
    public void testTerminalWithDiscounts() {

        Terminal terminal = new TerminalImpl();
        terminal.addProducts('A', 'B', 'C', 'D', 'A', 'B', 'A');
        BigDecimal result = terminal.calculateTotal();
        Assert.assertTrue(result.floatValue() == 13.25);
        terminal.reset();
        terminal.addProducts('C', 'C', 'C', 'C', 'C', 'C', 'C');
        result = terminal.calculateTotal();
        Assert.assertTrue(result.floatValue() == 6.00);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testTerminalWithUnknownProduct() {

        Terminal terminal = new TerminalImpl();
        terminal.addProducts('Z');
    }
}
