package stock.spring.mvc.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import stock.spring.mvc.database.ProductDao;

public class JdbcTemplateProductDao implements ProductDao {

	private DataSource dataSource;	

	public JdbcTemplateProductDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}



	/* (non-Javadoc)
	 * @see stock.spring.mvc.database.ProductDao#getProductList()
	 */
	@Override
	public List<Product> getProductList() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		List<Product> actual = jdbc.query("select * from products", new RowMapper<Product>(){

			@Override
			public Product mapRow(ResultSet arg0, int arg1) throws SQLException {
				
				return Product.create(arg0.getDouble(3), arg0.getString(2));
			}
			
		});
		return actual;
	}



	/* (non-Javadoc)
	 * @see stock.spring.mvc.database.ProductDao#save(stock.spring.mvc.domain.Product)
	 */
	@Override
	public void save(Product create) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.update( "update products set price = " + create.getPrice() + " where id = " + create.getId());
		
	}

}
