package org.clothesstore.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "org.clothesstore.config")
public class ConfigProperties {

	@Bean("mensajes")
	public PropertiesFactoryBean mapMessages() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("mensajes.properties"));
		return bean;
	}
	
	@Bean("sql")
	public PropertiesFactoryBean placeHolderConfigurer() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("sql.properties"));
		return bean;
	}
	

}
