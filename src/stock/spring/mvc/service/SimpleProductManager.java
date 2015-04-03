package stock.spring.mvc.service;

import java.util.List;

import stock.spring.mvc.database.ProductDao;
import stock.spring.mvc.domain.Product;
import stock.spring.mvc.domain.StubProductDao;

public class SimpleProductManager implements ProductManager {

	private ProductDao productDao = new StubProductDao();
	
	public SimpleProductManager(){
		
	}
	
	
	
	public ProductDao getProductDao() {
		return productDao;
	}



	public void setProductDao(StubProductDao productDao) {
		this.productDao = productDao;
	}



	/* (non-Javadoc)
	 * @see stock.spring.mvc.service.ProductManager#getProducts()
	 */
	@Override
	public List<Product> getProducts() {
		
		return productDao.getProductList();
	}

	/* (non-Javadoc)
	 * @see stock.spring.mvc.service.ProductManager#increasePrice(int)
	 */
	@Override
	public void increasePrice(int percentage) {
	
		for(Product product : productDao.getProductList()){
			product.setPrice(product.getPrice()*(100 + percentage)/100);
			productDao.save(product);
		}	
		
	}

}
