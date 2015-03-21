package stock.spring.mvc.service;

import java.util.ArrayList;
import java.util.List;

import stock.spring.mvc.domain.Product;

public class SimpleProductManager implements ProductManager {

	List<Product> product = new ArrayList<>();
	
	public SimpleProductManager(){
				
		product.add(Product.create(20.50, "Chair"));
		product.add(Product.create(150.10, "Table"));
	}
	
	/* (non-Javadoc)
	 * @see stock.spring.mvc.service.ProductManager#getProducts()
	 */
	@Override
	public List<Product> getProducts() {
		
		return product;
	}

	/* (non-Javadoc)
	 * @see stock.spring.mvc.service.ProductManager#increasePrice(int)
	 */
	@Override
	public void increasePrice(int percentage) {
	
		for(Product product : product)
			product.setPrice(product.getPrice()*(100 + percentage)/100);
		
	}

}
