package com.redhat.consulting.fuse.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestDefinitions extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
				
		restConfiguration()
		.component("servlet")
		.contextPath("/demo")
		.apiContextPath("/api-doc") //Swagger
			.apiProperty("api.title", "User API").apiProperty("api.version", "1.2.3") //Swagger
			.apiProperty("cors", "true")			
        .enableCORS(true)        
        .corsHeaderProperty("Access-Control-Allow-Origin", "*")
        .corsHeaderProperty("Access-Control-Allow-Credentials", "true")
		.corsHeaderProperty("Access-Control-Allow-Methods", "GET, HEAD, OPTIONS, POST, PUT, DELETE")        
        .corsHeaderProperty("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization")                  
        .corsHeaderProperty("Access-Control-Max-Age", "86400")
        .bindingMode(RestBindingMode.json);				

	}
}
