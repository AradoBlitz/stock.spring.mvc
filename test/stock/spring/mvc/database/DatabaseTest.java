package stock.spring.mvc.database;



import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DatabaseConf.class})
@TestExecutionListeners({SqlScriptsTestExecutionListener.class})
public class DatabaseTest {

	@Test
	@Sql({"/test-schema.sql","/load_data.sql"})
	public void testName() throws Exception {
		fail();
	}
}
