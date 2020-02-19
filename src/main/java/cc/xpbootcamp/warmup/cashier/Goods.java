package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;

public class Goods {
	private String title;
	private double price;
	private int quantity;

	private DecimalFormat df = new DecimalFormat("#.00");


	public Goods(String title, double price, int quantity) {
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

    double totalAmount() {
        return price * quantity;
    }

    public String getDetail(){
		StringBuilder output = new StringBuilder();
		output.append(getTitle());
		output.append(", ");
		output.append(df.format(getPrice()));
		output.append(" x ");
		output.append(getQuantity());
		output.append(", ");
		output.append(df.format(totalAmount()));
		output.append('\n');
		return output.toString();
	}

}