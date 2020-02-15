package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        printHeader(output);
        printBody(output);
        return output.toString();
    }

    private void printBody(StringBuilder output) {
        double totSalesTx = 0d;
        double tot = 0d;
        for (Goods goods : order.getLineItems()) {
            output.append(goods.getDetail());
            double salesTax = goods.totalAmount() * .10;
            totSalesTx += salesTax;
            tot += goods.totalAmount() + salesTax;
        }

        output.append("Sales Tax").append('\t').append(totSalesTx);

        output.append("Total Amount").append('\t').append(tot);
    }

    private void printHeader(StringBuilder output) {
        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

    }
}