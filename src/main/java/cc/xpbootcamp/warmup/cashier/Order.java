package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private List<LineItem> lineItemList;
    private double sumAmount;
    private double totalSalesTax;
    private double totalDiscount;


    public Order(List<LineItem> lineItemList) {
        this.lineItemList = lineItemList;
        this.sumAmount = getSum();
        this.totalSalesTax = getTotalSalesTax();
        this.totalDiscount = getTotalDiscount();
    }

    public String printGoodsList() {
        StringBuilder output = new StringBuilder();
        lineItemList.forEach(lineItem -> output.append(lineItem.getDetail()));
        return output.toString();
    }

    private double getSum() {
        return lineItemList.stream().mapToDouble(LineItem::totalAmount).sum();
    }

    public double getTotalSalesTax() {
        return sumAmount * .10;
    }

    public double getTotalDiscount() {
        return (sumAmount + totalSalesTax) * (1 - .98);
    }


    public double getTotalAmountWithNoDiscount() {
        return sumAmount + totalSalesTax;
    }

    public double getTotalAmountWithDiscount() {
        return sumAmount + totalSalesTax - totalDiscount;
    }

}
