package stock.spring.mvc.database;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import stock.spring.mvc.domain.JdbcTemplateProductDao;

@Configuration
public class DatabaseConf {

	@Bean
	public DataSource init(){
	
		return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.HSQL)
        .build();
	}
	
	@Bean
	public ProductDao createProductDao(){
		return new JdbcTemplateProductDao(init());
	}
}
