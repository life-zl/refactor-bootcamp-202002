package cc.xpbootcamp.warmup.cashier;

public class LineItem {
    private String title;
    private double price;
    private int quantity;


    public LineItem(String title, double price, int quantity) {
        super();
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double getTotalAmount() {
        return price * quantity;
    }


}