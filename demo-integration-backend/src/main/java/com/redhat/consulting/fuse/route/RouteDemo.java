package com.redhat.consulting.fuse.route;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redhat.consulting.fuse.entity.PersonEntity;
import com.redhat.consulting.fuse.model.PersonModel;
import com.redhat.consulting.fuse.processor.RegisterPersonProcessor;

@Component
public class RouteDemo extends RouteBuilder {
	private static Logger LOGGER = LoggerFactory.getLogger(RouteDemo.class);
	
	
	@Autowired
	private RegisterPersonProcessor registerPersonProcessor;
	
	
	@Override
	public void configure() throws Exception {
		
		
		restConfiguration()
		.component("servlet")
		.contextPath("/demo")
        .enableCORS(true)
        .corsHeaderProperty("Access-Control-Allow-Origin", "*")
        .corsHeaderProperty("Access-Control-Allow-Credentials", "true")
		.corsHeaderProperty("Access-Control-Allow-Methods", "GET, HEAD, OPTIONS, POST, PUT, DELETE")        
        .corsHeaderProperty("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, authorization")                  
		.bindingMode(RestBindingMode.json);				
		
		
		rest("/demo/fis")
		.produces("application/json")		
		
		.post("/person")
		.id("post-register-person")
		.produces("application/json")
		.type(com.redhat.consulting.fuse.model.PersonModel.class)
		.to("direct:register-person")
		
		.get("/person")
		.consumes("application/json")
		.id("get-find-all-people")
		.outType(com.redhat.consulting.fuse.model.PersonModel.class)
		.to("direct:find-all-people")
		
		.get("/person/{id}")
		.id("get-find-person-by-id")
		.outType(com.redhat.consulting.fuse.model.PersonModel.class)
		.to("direct:find-person-by-id")		

		.delete("/person/{id}")
		.id("get-find-person-by-id")
		.outType(com.redhat.consulting.fuse.model.PersonModel.class)
		.to("direct:delete-person")
		
		.get("/state")
		.id("get-find-all-states")
		.consumes("application/json")
		.outType(com.redhat.consulting.fuse.model.StateModel.class)		
		.to("direct:find-all-states")		

		.get("/country")
		.consumes("application/json")
		.id("get-find-all-countries")
		.outType(com.redhat.consulting.fuse.model.CountryModel.class)
		.to("direct:find-all-countries");

		
		// ROUTES						
		from("direct:register-person")
		.id("register-person")
		.routeId("register-person")
		.process(this.registerPersonProcessor)		
		.toD("jpa://com.redhat.consulting.fuse.model.PersonEntity?useExecuteUpdate=true")
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(204));

		from("direct:find-all-people")
		.id("find-all-people")	
		.to("jpa://com.redhat.consulting.fuse.entity.PersonEntity?namedQuery=findAllPeople")
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {

				List<PersonEntity> entitys = exchange.getIn().getBody(List.class);
				List<PersonModel> models = new ArrayList<PersonModel>();
				for (PersonEntity item : entitys) {
					models.add(item.toModel());				
				}
				exchange.getIn().setBody(models);				
				
			}
		});
		
		from("direct:find-person-by-id")
		.id("find-person-by-id")
		.toD("jpa://com.redhat.consulting.fuse.entity.PersonEntity?query=select a from PersonEntity a where id = ${header.id}");		

		from("direct:delete-person")
		.id("delete-person")		
		.toD("jpa://com.redhat.consulting.fuse.entity.PersonEntity?nativeQuery=delete from person a where a.id = ${header.id}")		
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(204));
		
		from("direct:find-all-states")
		.id("find-all-states")		
		.to("jpa://com.redhat.consulting.fuse.entity.StateEntity?namedQuery=findAllStates");		
		
		from("direct:find-all-countries")
		.id("get-find-all-countries")		
		.to("jpa://com.redhat.consulting.fuse.entity.CountryEntity?namedQuery=findAllCountries");	    
    	
	}
}
