package stock.spring.mvc.domain;

import java.util.ArrayList;
import java.util.List;

import stock.spring.mvc.database.ProductDao;

public class StubProductDao implements ProductDao{

	private List<Product> product;

	public StubProductDao() {
		product = new ArrayList<>();
		product.add(Product.create(20.50, "Chair"));
		product.add(Product.create(150.10, "Table"));
	}
	
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return product;
	}
 
	public void save(Product product) {
		// TODO Auto-generated method stub
		
	}

}
