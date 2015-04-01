package stock.spring.mvc.database;



import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DatabaseConf.class)              //Неприятность от спринга. Нужно добавлять руками если используешь слистенеры теста. Что ещё потеряно?
@TestExecutionListeners({SqlScriptsTestExecutionListener.class,DependencyInjectionTestExecutionListener.class})
public class DatabaseTest {

	
	@Autowired
    private DataSource dataSource;

	@Test
	@Sql({"/test-schema.sql","/load_data.sql"})
	public void testName() throws Exception {
		assertNotNull("Datasource should be autowired",dataSource);
	}
}
