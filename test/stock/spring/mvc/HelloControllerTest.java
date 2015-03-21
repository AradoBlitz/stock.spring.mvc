package stock.spring.mvc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class HelloControllerTest {

	@Test
	public void handleRequestView() throws Exception {
		HelloController controller = new HelloController();
		ModelAndView modelAndView = controller.handleRequest(null,null);
		assertNotNull("Request should be routed by controller",modelAndView);
		assertEquals("hello", modelAndView.getViewName());
		assertNotNull("NOW attribute should be provided",(String)modelAndView.getModel().get("now"));
	}
}
