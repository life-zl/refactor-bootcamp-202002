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

    public String printGoodsList(){
        StringBuilder output = new StringBuilder();
        goodsList.forEach(goods -> output.append(goods.getDetail()));
        return output.toString();
    }

    public String getTotalSalesTax(){
        return df.format(goodsList.stream().mapToDouble(GoodsRefactor::getSalesTax).sum());
    }

    public String getTotalAmount(){
        return df.format(goodsList.stream().mapToDouble(goods -> goods.totalAmount() + goods.getSalesTax()).sum());
    }
}
