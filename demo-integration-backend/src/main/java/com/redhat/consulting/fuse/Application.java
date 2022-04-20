package com.redhat.consulting.fuse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties

@SpringBootApplication
@ImportResource({"classpath:spring/camelContext.xml"})
@PropertySource("classpath:application.properties")
//@PropertySource("file:/opt/fuse/application.properties")
public class Application {
	
	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }  
    
}
