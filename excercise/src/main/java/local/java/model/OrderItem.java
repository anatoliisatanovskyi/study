package local.java.model;

public class OrderItem {

	private String name;
	private Double price;

	public OrderItem() {
		super();
	}

	public OrderItem(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderItem [name=" + name + ", price=" + price + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
