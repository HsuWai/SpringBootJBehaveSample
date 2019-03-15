package com.singtel.voucher.config;

import java.util.Collections;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration for spring datasource
 *
 */
@Configuration
@EnableSwagger2
@PropertySource( value= {"classpath:application.properties"})
@EnableJpaRepositories("com.singtel.voucher.repository")
public class WebAppConfiguration extends WebMvcConfigurationSupport{
	
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
	
	// Swagger configuration
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
        	.select().apis(RequestHandlerSelectors.basePackage("com.singtel.voucher.controller"))
        	.paths(PathSelectors.any())
        	.build()
        	.useDefaultResponseMessages(false) // to remove default response messages in swagger docs
        	.apiInfo(apiInfo());                                     
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
        	"REST API for product mangment",
        	"API for create, read, update and delete of products",
        	"API TOS",
        	"Terms of service",
        	new Contact("Hsu Wai Wai Tun", "www.example.com", "hsuwai.waitun@ncs.com.sg"),
        	"License of API", "API license URL", Collections.emptyList());
    }
    
    // This is needed for swagger-ui
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
          .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
          .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
