package stock.spring.mvc.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import stock.spring.mvc.domain.PriceIncrease;
import stock.spring.mvc.service.ProductManager;

@Controller
@RequestMapping(value="/priceincrease")
public class PriceIncreaseFormController {

	private ProductManager productManager;

	@RequestMapping(method=RequestMethod.GET)
	public String show(Map<String, Object> model) {
		model.put("priceIncrease", new PriceIncrease());
		System.out.println("Show increase form");
		return "priceincrease";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String process(@ModelAttribute("priceIncrease") PriceIncrease priceIncrease, Map<String, Object> model) {
		productManager.increasePrice(priceIncrease.getPercentage());
		System.out.println("Increase Price by percentage"+priceIncrease.getPercentage());
		return "redirect:/";
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;		
	}

}
