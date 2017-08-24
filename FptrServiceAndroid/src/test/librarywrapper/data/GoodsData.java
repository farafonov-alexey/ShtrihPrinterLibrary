package test.librarywrapper.data;

import test.librarywrapper.constants.ReceiptTemplateText;

/**
 * Created by mamba on 10.08.2017.
 */

public class GoodsData {
    private final double price;
    private final String name;
    private final int quantity;

    public GoodsData(double price, String name, int quantity) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}