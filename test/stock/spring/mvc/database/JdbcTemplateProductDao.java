package stock.spring.mvc.database;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import stock.spring.mvc.domain.Product;

public class JdbcTemplateProductDao {

	private DataSource dataSource;	

	public JdbcTemplateProductDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}



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



	public void save(Product create) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.update( "update products set price = " + create.getPrice() + " where id = 1");
				/*, new MapSqlParameterSource()
		.addValue("description", create.getDescription())
		.addValue("price", new BigDecimal(22.10))		
		.addValue("id", new Integer(1)));*/
		
	}

}
