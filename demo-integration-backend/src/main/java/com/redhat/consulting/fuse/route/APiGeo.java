package com.redhat.consulting.fuse.route;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.redhat.consulting.fuse.entity.CountryEntity;
import com.redhat.consulting.fuse.entity.StateEntity;
import com.redhat.consulting.fuse.model.CountryModel;

@Component
public class APiGeo extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
				
		rest("/geo")
		.get("/country")
		.id("get-find-all-countries")
		.consumes("application/json")		
		.outType(com.redhat.consulting.fuse.model.CountryModel.class)
		.to("direct:find-all-countries")
	
		.get("/state/{countryCode}")
		.id("get-find-all-states")
		.consumes("application/json")
		.outType(StateEntity.class)		
		.to("direct:find-all-states");	

		// ROUTES				
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
		   
    	
	}
}
