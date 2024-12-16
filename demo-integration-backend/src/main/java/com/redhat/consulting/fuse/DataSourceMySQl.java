package com.redhat.consulting.fuse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
public class DataSourceMySQl {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceMySQl.class);

	@Value("${DATABASE_MYSQL_URL}")
	private String dataBaseUrl;

	@Value("${DATABASE_MYSQL_USERNAME}")
	private String dataBaseUsername;

	@Value("${DATABASE_MYSQL_PASSWORD}")
	private String dataBasePassword;

	@Bean
	public DataSource getDataSource() {

		LOGGER.info("#### DATABASE ##################################");
		LOGGER.info("#### DATABASE_MYSQL_URL: {}", this.dataBaseUrl);
		LOGGER.info("#### DATABASE_MYSQL_USERNAME: {}", this.dataBaseUsername);
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(this.dataBaseUrl);
		
		dataSource.setUsername(this.dataBaseUsername);
		dataSource.setPassword(this.dataBasePassword);

		return dataSource;
	}
}
