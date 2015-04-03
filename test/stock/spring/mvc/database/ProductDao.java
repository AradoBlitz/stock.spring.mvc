package stock.spring.mvc.database;

import java.util.List;

import stock.spring.mvc.domain.Product;

public interface ProductDao {

	public abstract List<Product> getProductList();

	public abstract void save(Product create);

}