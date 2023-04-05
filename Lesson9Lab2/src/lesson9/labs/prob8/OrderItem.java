package lesson9.labs.prob8;

public class OrderItem {
	private Product product;
	private int quantityRequested;
	private double totalPrice;
	//package level constructor
	OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantityRequested = quantity;
		if (product != null) {
			totalPrice = product.getUnitPrice() * quantity;
		}
	}
	@Override
	public String toString() {
		String productId = product != null ? product.getProductId() : "null";
		String unitPrice = product != null ? "" + product.getUnitPrice() : "null";
		return "   " + productId + ": " + quantityRequested + ", " + unitPrice;
	}
	public Product getProduct() {
		return product;
	}
	public int getQuantityRequested() {
		return quantityRequested;
	}
	public double getTotalPrice() {
		return totalPrice;
	}


}
