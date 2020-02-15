package cc.xpbootcamp.warmup.cashier;

public class Goods {
	private String desc;
	private double price;
	private int quantity;

	public Goods(String desc, double price, int quantity) {
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
		output.append('\t');
		output.append(getPrice());
		output.append('\t');
		output.append(getQuantity());
		output.append('\t');
		output.append(totalAmount());
		output.append('\n');
		return output.toString();
	}

	public double getSalesTax() {
		return totalAmount() * .10;
	}
}