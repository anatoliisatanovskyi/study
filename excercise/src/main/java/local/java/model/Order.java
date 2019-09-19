package local.java.model;

public class Order {

	private OrderItem orderItem;
	private Integer quantity;

	public Order() {
		super();
	}

	public Order(OrderItem orderItem, Integer quantity) {
		this.orderItem = orderItem;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [orderItem=" + orderItem + ", quantity=" + quantity + "]";
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
