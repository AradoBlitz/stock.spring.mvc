package stock.spring.mvc.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import stock.spring.mvc.service.ProductManager;
import stock.spring.mvc.service.SimpleProductManager;

public class InventoryController implements Controller{

	private ProductManager productManager;
	
	public ProductManager getProductManager() {
		return productManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> model = new HashMap<>();
		model.put("now",new Date().toString());
		model.put("products", productManager.getProducts());
		return new ModelAndView("inventory",model);
	}

}
