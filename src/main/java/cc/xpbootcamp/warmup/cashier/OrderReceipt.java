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
        output.append(buildHeader());
        output.append(buildBody());
        output.append(buildTail());
        return output.toString();
    }

    private StringBuilder buildHeader() {
        StringBuilder header = new StringBuilder();
        header.append("======Printing Orders======\n");
        header.append(order.getCustomerName());
        header.append(order.getCustomerAddress());
        return header;
    }

    private String buildBody() {
        return order.printGoodsList();
    }

    private StringBuilder buildTail() {
        StringBuilder tail = new StringBuilder();
        tail.append("Sales Tax").append('\t').append(order.getTotalSalesTax()).append("\n");
        tail.append("Total Amount").append('\t').append(order.getTotalAmount());
        return tail;
    }
}