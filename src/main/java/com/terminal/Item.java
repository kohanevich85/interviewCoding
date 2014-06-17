package com.terminal;

import java.math.BigDecimal;

/**
 * Created by denis.
 */
public class Item {

    private int quantity;
    private Product product;
    private BigDecimal totalPrice;

    protected Item(char productType) {
        this.product = Product.resolveType(productType);
        this.quantity = 1;
        this.totalPrice = product.getPrice();
    }

    protected void addItem() {
        quantity++;
        totalPrice = totalPrice.add(product.getPrice());
    }

    protected static Item addFirstItem(char productType) {
        return new Item(productType);
    }

    protected Product getProduct() {
        return product;
    }

    protected BigDecimal getTotalPrice() {

        int volumePrices = product.getVolumePrices();
        BigDecimal specialPrice = product.getSpecialPrice();
        BigDecimal standardPrice = product.getPrice().multiply(new BigDecimal(quantity % volumePrices));
        BigDecimal discountPrice = specialPrice.multiply(new BigDecimal(quantity / volumePrices));
        return standardPrice.add(discountPrice);
    }
}
