package stock.spring.mvc.service;

import java.util.List;

import stock.spring.mvc.domain.Product;

public interface ProductManager {

	public abstract List<Product> getProducts();

	public abstract void increasePrice(int percentage);

}