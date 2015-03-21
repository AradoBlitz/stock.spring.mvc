package stock.spring.mvc.domain;

public class Product {

	public static Product create(double price, String description) {
		Product chair = new Product();
		chair.setPrice(price);		
		chair.setDescription(description);
		return chair;
	}
	
	private double price;
	private String description;

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		
		return price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {

		return description;
	}

	@Override
	public boolean equals(Object obj) {
		Product product = (Product)obj;
		return price == product.price && description.equals(product.description);
	}

	

	@Override
	public String toString() {
		return "Product [Price=" + price + ", Description=" + description + "]";
	}

	
}
