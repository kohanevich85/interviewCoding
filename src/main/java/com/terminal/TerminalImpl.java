package com.terminal;

import java.math.BigDecimal;

/**
 * Created by denis.
 */
public class TerminalImpl implements Terminal {

    private Receipt receipt;

    public TerminalImpl() {
        receipt = new Receipt();
    }

    public void addProduct(char product) {
        receipt.addItem(product);
    }

    public void addProducts(char... products) {
        for (char product : products) {
            receipt.addItem(product);
        }
    }

    public BigDecimal calculateTotal() {
        return receipt.calculateTotal();
    }

    public void reset() {
        receipt = new Receipt();
    }
}
