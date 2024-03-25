package com.redhat.consulting.fuse.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.redhat.consulting.fuse.model.HttpStatusModel;

@Component
public class APIPing extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {

		rest("/test")
		.produces("application/json")	
		
		.get("/ping204")
		.id("get-ping204")
		.outType(com.redhat.consulting.fuse.model.HttpStatusModel.class)	
		.to("direct:response-204")	
		
		.get("/ping200")
		.id("get-ping200")
		.outType(com.redhat.consulting.fuse.model.HttpStatusModel.class)	
		.to("direct:response-200")
		
		.get("/ping200/{requestIndex}")
		.id("get-ping200")
		.outType(com.redhat.consulting.fuse.model.HttpStatusModel.class)	
		.to("direct:response-200");			
		
				
		from("direct:response-204").routeId("response-204")
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(204));   

		from("direct:response-200").routeId("response-200")
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
								
				Integer index = null;
				
				try {
					index = exchange.getIn().getHeader("requestIndex",Integer.class);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (null == index) {
					exchange.getOut().setBody(new HttpStatusModel(200));	
				} else {
					exchange.getOut().setBody(new HttpStatusModel(200, index));	
				}
				
				
				
			}
		})
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200)); 		
	}
}
