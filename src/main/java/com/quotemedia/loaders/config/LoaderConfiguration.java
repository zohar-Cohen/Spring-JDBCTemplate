package com.quotemedia.loaders.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScans(value = { @ComponentScan("com.quotemedia.loaders.dao"),
		@ComponentScan("com.quotemedia.loaders.service"),
		@ComponentScan("com.quotemedia.loaders.loader")})
public class LoaderConfiguration {

	@Autowired
	Environment env;

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		dataSource.setDefaultAutoCommit(false);
		System.out.println("Data source Bean has been loaded with the follwing attributes:");
		System.out.printf("Driver: %s, Url %s, UserName %s, Password: %s \n",dataSource.getDriverClassName(), dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
		return dataSource;
	}

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}

	@Bean(name = "txName")
	public PlatformTransactionManager txManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource());
		return txManager;
	}

}
