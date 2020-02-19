package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.utils.DateUtil;

import java.text.DecimalFormat;
import java.util.Calendar;

import static cc.xpbootcamp.warmup.cashier.constants.FieldConstant.*;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    private DecimalFormat df = new DecimalFormat(NUMBER_PATTERN);


    public OrderReceipt(Order order) {
        this.order = order;
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
        header.append("====== 老王超市,值得信赖 ======")
                .append(BLANK_LINE)
                .append(DateUtil.getDateInfo())
                .append(BLANK_LINE);
        return header;
    }


    private String buildBody() {
        return order.printGoodsList();
    }

    private StringBuilder buildFooter() {
        StringBuilder footer = new StringBuilder();
        footer.append("------------------\n");
        footer.append(TOTAL_TAX_TEXT).append(EMPTY_STRING).append(df.format(order.totalSalesTax)).append("\n");
        if (DateUtil.getWeekOfDate(Calendar.getInstance()).equals(WEDNESDAY)) {
            footer.append(TOTAL_DISCOUNT_TEXT).append(EMPTY_STRING).append(df.format(order.totalDiscount)).append("\n");
            footer.append(TOTAL_AMOUNT_TEXT).append(EMPTY_STRING).append(df.format(order.getTotalAmountWithDiscount()));
        } else {
            footer.append(TOTAL_AMOUNT_TEXT).append(EMPTY_STRING).append(df.format(order.getTotalAmountWithNoDiscount()));
        }
        return footer;
    }
}