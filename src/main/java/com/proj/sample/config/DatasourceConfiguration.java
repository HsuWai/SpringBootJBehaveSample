package com.proj.sample.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Configuration for spring datasource
 *
 */
@Configuration
@PropertySource( value= {"classpath:application.properties"})
@EnableJpaRepositories("com.proj.sample.repository")
public class DatasourceConfiguration extends WebMvcConfigurationSupport{
	
	@Value("${spring.datasource.driverClassName}")
	private String driverName;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;

	@SuppressWarnings("rawtypes")
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);
		dataSourceBuilder.driverClassName(driverName);
		return dataSourceBuilder.build();
	}
}
