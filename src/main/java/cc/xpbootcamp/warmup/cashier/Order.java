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

    public String printGoodsList(){
        StringBuilder output = new StringBuilder();
        goodsList.stream().forEach(goods -> {
            output.append(goods.getDetail());
        });
        return output.toString();
    }

    public double getTotalSalesTax(){
        double totalSalesTax = 0;
        for (Goods goods : goodsList) {
            totalSalesTax += goods.getSalesTax();
        }
        return totalSalesTax;
    }

    public double getTotalAmount(){
        double totalAmount = 0;
        for (Goods goods : goodsList) {
            totalAmount += goods.totalAmount() + goods.getSalesTax();
        }
        return totalAmount;
    }
}
