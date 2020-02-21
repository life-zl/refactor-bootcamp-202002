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

    public List<LineItem> getLineItemList() {
        return lineItemList;
    }

    private double getSum() {
        return lineItemList.stream().mapToDouble(LineItem::getTotalAmount).sum();
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
