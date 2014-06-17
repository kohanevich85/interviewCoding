package com.terminal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.terminal.Item.addFirstItem;

/**
 * Created by denis.
 */
public class Receipt {

    private List<Item> items;

    protected Receipt() {
        this.items = new ArrayList<Item>();
    }

    protected void addItem(char productType) {
        for (Item item : items) {
            if (item.getProduct().getProductType() == productType) {
                item.addItem();
                return;
            }
        }
        items.add(addFirstItem(productType));
    }

    protected BigDecimal calculateTotal() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Item item : items) {
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }
}
