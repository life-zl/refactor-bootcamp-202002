package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceiptRefactor {
    private Order order;

    public OrderReceiptRefactor(Order order) {
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
        header.append("====== 老王超市,值得信赖 ======\n");
        header.append("\n");
        return header;
    }

    private String buildBody() {
        return order.printGoodsList();
    }

    private StringBuilder buildFooter() {
        StringBuilder footer = new StringBuilder();
        footer.append("------------------\n");
        footer.append("Sales Tax").append('\t').append(order.getTotalSalesTax()).append("\n");
        footer.append("Total Amount").append('\t').append(order.getTotalAmount());
        return footer;
    }
}