package stock.spring.mvc.web;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import stock.spring.mvc.domain.PriceIncrease;
import stock.spring.mvc.domain.Product;
import stock.spring.mvc.service.ProductManager;
import stock.spring.mvc.service.SimpleProductManager;

public class PriceIncreaseFormControllerTest {

	@Test
	public void showForm() throws Exception {
		
		PriceIncreaseFormController controller = new PriceIncreaseFormController();
		Map<String,Object> model = new HashMap<>();
		assertEquals("priceincrease", controller.show(model));
		assertEquals(new PriceIncrease(),model.get("priceIncrease"));
	}
	
	@Test
	public void proccess() throws Exception {
		
		ProductManager productManager = new SimpleProductManager();
		PriceIncreaseFormController increaseController = new PriceIncreaseFormController();
		increaseController.setProductManager(productManager);
		Map<String, Object> model = new HashMap<String, Object>();
		PriceIncrease priceIncrease = new PriceIncrease();
		priceIncrease.setPercentage(10);
		assertEquals("redirect:/", increaseController.process(priceIncrease ,model));
		assertEquals(Product.create(22.55,"Chair"), productManager .getProducts().get(0));
		assertEquals(Product.create(165.11,"Table"), productManager.getProducts().get(1));
	}
}
