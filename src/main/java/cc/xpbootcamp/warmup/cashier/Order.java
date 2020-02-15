package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String customerName;
    String customerAddress;
    List<Goods> goodsList;

    public Order(String cName, String customerAddress, List<Goods> goodsList) {
        this.customerName = cName;
        this.customerAddress = customerAddress;
        this.goodsList = goodsList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<Goods> getLineItems() {
        return goodsList;
    }
}
