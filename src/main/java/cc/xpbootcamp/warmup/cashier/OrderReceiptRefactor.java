package cc.xpbootcamp.warmup.cashier;

import java.util.Calendar;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceiptRefactor {
    private OrderRefactor orderRefactor;

    public OrderReceiptRefactor(OrderRefactor orderRefactor) {
        this.orderRefactor = orderRefactor;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output.append(buildHeader());
        output.append(buildBody());
        output.append(buildFooter());
        return output.toString();
    }

    private StringBuilder buildHeader() {
        StringBuilder header = new StringBuilder();
        header.append("====== 老王超市,值得信赖 ======\n");
        header.append("\n");
        header.append(getDateInfo() + "\n");
        header.append("\n");
        return header;
    }

    private String getDateInfo() {
        Calendar now = Calendar.getInstance();
        return String.format("%s年%s月%s日， %s",
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH) + 1,
                now.get(Calendar.DAY_OF_MONTH),
                getWeekOfDate(now));
    }

    public static String getWeekOfDate(Calendar date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int w = date.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    private String buildBody() {
        return orderRefactor.printGoodsList();
    }

    private StringBuilder buildFooter() {
        StringBuilder footer = new StringBuilder();
        footer.append("------------------\n");
        footer.append("税额： ").append(orderRefactor.getTotalSalesTaxStr()).append("\n");
        if (getWeekOfDate(Calendar.getInstance()).equals("星期三")) {
            footer.append("折扣： ").append(orderRefactor.getTotalDiscountStr()).append("\n");
            footer.append("总价： ").append(orderRefactor.getTotalAmountStrWithDiscount());
        } else {
            footer.append("总价： ").append(orderRefactor.getTotalAmountStr());
        }
        return footer;
    }
}