package org.clothesstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourcesConfig implements WebMvcConfigurer {
	
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/resources/"};
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/empleados/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	}

}
