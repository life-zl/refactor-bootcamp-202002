package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class OrderRefactor {
    List<Goods> goodsList;
    double sumAmount;
    double totalSalesTax;
    double totalDiscount;


    public OrderRefactor(List<Goods> goodsList) {
        this.goodsList = goodsList;
        this.sumAmount = getSum();
        this.totalSalesTax = getTotalSalesTax();
        this.totalDiscount = getTotalDiscount();
    }

    public String printGoodsList() {
        StringBuilder output = new StringBuilder();
        goodsList.forEach(goods -> output.append(goods.getDetail()));
        return output.toString();
    }

    private double getSum() {
        return goodsList.stream().mapToDouble(Goods::totalAmount).sum();
    }

    public double getTotalSalesTax() {
        return sumAmount * .10;
    }

    private double getTotalDiscount() {
        return (sumAmount + totalSalesTax) * (1 - .98);
    }


    public double getTotalAmountWithNoDiscount() {
        return sumAmount + totalSalesTax;
    }

    public double getTotalAmountWithDiscount() {
        return sumAmount + totalSalesTax - totalDiscount;
    }

}
