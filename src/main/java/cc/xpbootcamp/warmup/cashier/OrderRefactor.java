package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;
import java.util.List;

public class OrderRefactor {
    String customerName;
    String customerAddress;
    List<GoodsRefactor> goodsList;

    private DecimalFormat df = new DecimalFormat("#.00");


    public OrderRefactor(String customerName, String customerAddress, List<GoodsRefactor> goodsList) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.goodsList = goodsList;
    }

    public String printGoodsList() {
        StringBuilder output = new StringBuilder();
        goodsList.forEach(goods -> output.append(goods.getDetail()));
        return output.toString();
    }

    public double getTotalSalesTax() {
        return getSum() * .10;
    }

    public String getTotalSalesTaxStr() {
        return df.format(getTotalSalesTax());
    }

    public String getTotalDiscountStr() {
        return df.format(getTotalDiscount());
    }

    public String getTotalAmountStrWithDiscount() {
        return df.format(getSum() + getTotalSalesTax() - getTotalDiscount());
    }

    public String getTotalAmountStr() {
        return df.format(getSum() + getTotalSalesTax());
    }

    private double getSum() {
        return goodsList.stream().mapToDouble(GoodsRefactor::totalAmount).sum();
    }

    private double getTotalDiscount() {
        return (getSum() + getTotalSalesTax()) * (1 - .98);
    }

}
