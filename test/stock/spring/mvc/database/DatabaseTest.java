package stock.spring.mvc.database;



import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
@Sql({"/test-schema.sql","/load_data.sql"})
public class DatabaseTest {

	
	@Autowired
    private DataSource dataSource;
	@Autowired
	private JdbcTemplateProductDao productDao;

	@Test
	public void testName() throws Exception {
		
		List<Product> productList = productDao.getProductList();
		assertEquals(Product.create(5.78, "Lamp"), productList.get(0));
		productDao.save(Product.create(22.10, "Lamp"));
		assertEquals(Product.create(22.10, "Lamp"), productDao.getProductList().get(0));
	}
}
