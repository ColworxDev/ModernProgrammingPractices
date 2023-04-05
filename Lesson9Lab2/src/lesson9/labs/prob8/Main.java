package lesson9.labs.prob8;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	List<OrderItem> orderItems = new ArrayList<>();
	public static void main(String[] args) {
		Main m = new Main();
		m.loadOrderItemData();
		System.out.println("Do any of these Order Items have an order of flowers? " + 
		   m.findProduct("Toolst"));
	}
	
	private boolean findProduct(String prodName) {
//		 return orderItems.stream()
//				 .map(data -> Optional.ofNullable(data))
//				.map(data -> Optional.ofNullable(data.get().getProduct()))
//				 .map(data -> Optional.ofNullable(data.get().getProductName()))
//				 .map(Optional::get)
//				 .filter(data -> data.equals(prodName))
//				 .collect(Collectors.toList()).isEmpty() == false;

		 orderItems.stream()
				.flatMap(data-> Optional.ofNullable(data).stream())
				.flatMap(data -> Optional.ofNullable(data.getProduct()).stream())
				.flatMap(data -> Optional.ofNullable(data.getProductName()).stream())
				.filter(str-> str.equals(prodName))
				.findFirst().isPresent();

		return true;


//		Stream<OrderItem> orderItemStream = orderItems.stream()
//				.map(data -> Optional.ofNullable(data).orElseGet(()->new OrderItem(new Product("1", "pn", 1.2), 1)));
//		orderItems.stream()
//				.map(data -> Optional.ofNullable(data).orElseGet(()->new OrderItem(new Product("1", "pn", 1.2), 1)))
//				.map(data -> Optional.ofNullable(data.getProduct()).orElseGet(()->new Product("1", "pn", 1.2)))
//				.filter(data -> Optional.of(data).get().equals(prodName))
//				.findFirst()



//		return true;

//
//		for(OrderItem item : orderItems) {
//			if(item != null) {
//				Product p=item.getProduct();
//				if(p != null) {
//					String name = p.getProductName();
//					if(name != null) {
//						if(name.equals(prodName)) return true;
//					}
//				}
//			}
//		}
//		return false;
	}
	
	private void loadOrderItemData() {
		orderItems.add(null);
		orderItems.add(new OrderItem(null, 3));
		orderItems.add(new OrderItem(new Product("1016", null, 131.00), 3));
		orderItems.add(new OrderItem(new Product("1016", "Tools", 131.00), 3));
		orderItems.add(new OrderItem(new Product("1017", "Fishing Rod", 111.00), 1));
		orderItems.add(new OrderItem(new Product("1018", "Game of Go",66.00), 2));
		orderItems.add(new OrderItem(new Product("1019", "Flowers", 221.00), 5));
	}
}
