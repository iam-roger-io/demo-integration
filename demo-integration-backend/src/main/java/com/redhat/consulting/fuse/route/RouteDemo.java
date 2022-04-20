package com.redhat.consulting.fuse.route;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redhat.consulting.fuse.entity.CountryEntity;
import com.redhat.consulting.fuse.entity.PeopleEntity;
import com.redhat.consulting.fuse.entity.StateEntity;
import com.redhat.consulting.fuse.model.CountryModel;
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
		

		rest("/")
		.get("/geo/country")
		.id("get-find-all-countries")
		.consumes("application/json")		
		.outType(com.redhat.consulting.fuse.model.CountryModel.class)
		.to("direct:find-all-countries")
	
		.get("/geo/state/{countryCode}")
		.id("get-find-all-states")
		.consumes("application/json")
		.outType(StateEntity.class)		
		.to("direct:find-all-states");	
				
		rest("/crud")
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
		.to("direct:delete-person");

		
		// ROUTES				
		
		//geo API
		from("direct:find-all-countries")
		.routeId("find-all-countries")
		.to("jpa://com.redhat.consulting.fuse.entity.CountryEntity?namedQuery=findAllCountries")
		.process(exchange -> {
			
			List<CountryEntity> entitys = (List<CountryEntity>) exchange.getIn().getBody(List.class);
			List<CountryModel> models = new ArrayList<CountryModel>();
			entitys.stream().forEach((item) -> {
				models.add(new CountryModel(item.getCountryCode(), item.getName()));
			});			
			exchange.getIn().setBody(models);			
			
		 });
				
		from("direct:find-all-states")
		.routeId("find-all-states")
		.toD("jpa://com.redhat.consulting.fuse.entity.StateEntity?query=select a from StateEntity a where a.country.id = '${header.countryCode}'");
					
		

		//People API		
		from("direct:register-person").routeId("register-person")
		.process(this.registerPersonProcessor)		
		.toD("jpa://com.redhat.consulting.fuse.model.PeopleEntity?useExecuteUpdate=true")
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(204));

		from("direct:find-all-people")
		.id("find-all-people")	
		.to("jpa://com.redhat.consulting.fuse.entity.PeopleEntity?namedQuery=findAllPeople")
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {

				List<PeopleEntity> entitys = exchange.getIn().getBody(List.class);
				List<PersonModel> models = new ArrayList<PersonModel>();
				for (PeopleEntity item : entitys) {
					models.add(item.toModel());				
				}
				exchange.getIn().setBody(models);				
				
			}
		});		

		from("direct:find-person-by-id")
		.id("find-person-by-id")
		.toD("jpa://com.redhat.consulting.fuse.entity.PeopleEntity?query=select a from PeopleEntity a where id = ${header.id}");		

		from("direct:delete-person")
		.id("delete-person")		
		.toD("jpa://com.redhat.consulting.fuse.entity.PeopleEntity?nativeQuery=delete from person a where a.id = ${header.id}")		
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(204));
		   
    	
	}
}
