package stock.spring.mvc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import stock.spring.mvc.domain.Product;
import stock.spring.mvc.service.ProductManager;
import stock.spring.mvc.service.SimpleProductManager;
import stock.spring.mvc.web.InventoryController;

public class HelloControllerTest {

	@Test
	public void handleRequestView() throws Exception {
		InventoryController controller = new InventoryController();
		controller.setProductManager(new SimpleProductManager());
		ModelAndView modelAndView = controller.handleRequest(null,null);
		assertNotNull("Request should be routed by controller.",modelAndView);
		assertEquals("inventory", modelAndView.getViewName());
		assertNotNull("NOW attribute should be provided.",(String)modelAndView.getModel().get("now"));
		assertNotNull("Products list should be provided.",(List)modelAndView.getModel().get("products"));
	}
}
