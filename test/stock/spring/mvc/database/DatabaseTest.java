package stock.spring.mvc.database;



import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import stock.spring.mvc.domain.Product;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DatabaseConf.class)              
@TestExecutionListeners({SqlScriptsTestExecutionListener.class,DependencyInjectionTestExecutionListener.class})
public class DatabaseTest {

	
	@Autowired
    private DataSource dataSource;

	@Test
	@Sql({"/test-schema.sql","/load_data.sql"})
	public void testName() throws Exception {
		assertNotNull("Datasource should be autowired",dataSource);
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		Product actual = jdbc.queryForObject("select * from products", new RowMapper<Product>(){

			@Override
			public Product mapRow(ResultSet arg0, int arg1) throws SQLException {
				
				return Product.create(arg0.getDouble(3), arg0.getString(2));
			}
			
		});
		assertEquals(Product.create(5.78, "Lamp"), actual );
	}
}
