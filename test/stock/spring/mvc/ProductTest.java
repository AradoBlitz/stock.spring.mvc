package stock.spring.mvc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import stock.spring.mvc.domain.Product;
import stock.spring.mvc.domain.StubProductDao;
import stock.spring.mvc.service.SimpleProductManager;

public class ProductTest {

	SimpleProductManager productManager = new SimpleProductManager();
	
	@Before
	public void initProductManager(){
		productManager.setProductDao(new StubProductDao());
	}
	
	@Test
	public void getProductsList() throws Exception {
		
		
		assertNotNull("Product list should exist always.",productManager.getProducts());		
		int number = 0;
		assertEquals(Product.create(20.50,"Chair"),productManager.getProducts().get(number++));
		assertEquals(Product.create(150.10,"Table"),productManager.getProducts().get(number++));
		
	}
	
	@Test
	public void increasePriceForAllProducts() throws Exception {
	
		productManager.increasePrice(10);
		assertEquals(Product.create(22.55,"Chair"), productManager.getProducts().get(0));
		assertEquals(Product.create(165.11,"Table"), productManager.getProducts().get(1));
	}
}
