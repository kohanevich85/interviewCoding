package com.terminal;

import org.junit.Assert;

import java.math.BigDecimal;

/**
 * Created by denis
 */
public class Main {

    public static void main(String[] args) {

        TerminalImpl terminal = new TerminalImpl();
        terminal.addProducts('A','A', 'A', 'B', 'C', 'D');
        BigDecimal result = terminal.calculateTotal();

        System.out.println(result);
        Assert.assertTrue(result.floatValue() == 9);
    }
}
