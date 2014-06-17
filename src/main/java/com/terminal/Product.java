package com.terminal;

import java.math.BigDecimal;

/**
 * Created by denis.
 */
public enum Product {

    A('A', 1.25, 3, 3),
    B('B', 4.25, 1, 4.25),
    C('C', 1.00, 6, 5),
    D('D', 0.75, 1, 0.75);

    private char productType;
    private BigDecimal standardPrice;
    private int volumePrices;
    private BigDecimal specialPrice;

    private Product(char productType, double price, int volumePrices,  double specialPrice) {
        this.productType = productType;
        this.standardPrice = new BigDecimal(price);
        this.specialPrice = new BigDecimal(specialPrice);
        this.volumePrices = volumePrices;
    }

    protected BigDecimal getPrice() {
        return standardPrice;
    }

    protected char getProductType() {
        return productType;
    }

    public int getVolumePrices() {
        return volumePrices;
    }

    public BigDecimal getSpecialPrice() {
        return specialPrice;
    }

    protected static Product resolveType(char productType) {
        for (Product product : Product.values()) {
            if (product.productType == productType) return product;
        }
        throw new UnsupportedOperationException("no such element");
    }
}
