package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String customerName;
    String customerAddress;
    List<Goods> goodsList;

    public Order(String customerName, String customerAddress, List<Goods> goodsList) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.goodsList = goodsList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String printGoodsList(){
        StringBuilder output = new StringBuilder();
        goodsList.forEach(goods -> output.append(goods.getDetail()));
        return output.toString();
    }

    public double getTotalSalesTax(){
        return goodsList.stream().mapToDouble(Goods::getSalesTax).sum();
    }

    public double getTotalAmount(){
        return goodsList.stream().mapToDouble(goods -> goods.totalAmount() + goods.getSalesTax()).sum();
    }
}
