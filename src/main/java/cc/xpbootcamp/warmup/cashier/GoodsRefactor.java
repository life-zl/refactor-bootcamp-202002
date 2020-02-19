package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;

public class GoodsRefactor {
	private String desc;
	private double price;
	private int quantity;

	private DecimalFormat df = new DecimalFormat("#.00");


	public GoodsRefactor(String desc, double price, int quantity) {
		super();
		this.desc = desc;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return desc;
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
		output.append(getDescription());
		output.append(", ");
		output.append(df.format(getPrice()));
		output.append(" x ");
		output.append(getQuantity());
		output.append(", ");
		output.append(df.format(totalAmount()));
		output.append('\n');
		return output.toString();
	}

	public double getSalesTax() {
		return totalAmount() * .10;
	}
}