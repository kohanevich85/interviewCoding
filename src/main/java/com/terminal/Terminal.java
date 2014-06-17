package com.terminal;

import java.math.BigDecimal;

/**
 * Created by denis.
 */
public interface Terminal {

    public void addProduct(char product);

    public void addProducts(char... products);

    public BigDecimal calculateTotal();

    public void reset();
}
