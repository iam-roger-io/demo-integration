package com.redhat.consulting.fuse.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
/**
 * 
 * @author rosantos
 *
 * Definição de API e Rota para envio de EMAIl através de um servidor SMTP
 * 
 * @see https://camel.apache.org/components/3.18.x/mail-component.html#_setting_sender_name_and_email
 */
public class ApiRoute extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {

		/*
		 * 
		 * Definição do Endpoint REST para envio do email
		 * 
		 * Rest Definition for sending email
		 * 		
		 */
		rest("/api")
		.produces("application/json")		
		
		.post("/email")
		.id("post-sende-mail")
		.produces("application/json")
		.type(com.redhat.consulting.fuse.model.Email.class)
		.to("direct:send-email");
				
		/*
		 *  Rota que executa o envio.
		 *  
		 *  Route for sending the EMAIL.
		 */
		
		from("direct:send-email").routeId("send-email")		
		.log("####### Sending message uging smtp: {{demo.integration.smtp.host}} and username {{demo.integration.smtp.username}}")		
		.setHeader("From", constant("iam.roger.io@terra.com.br"))
		.setHeader("To", simple("${body.to}"))
		.setHeader("Reply-To", constant("iam.roger.io@terra.com.br"))
		.setHeader("Subject", simple("${body.subject}"))
		.setHeader("Content-Type", constant("text/plain"))
		.setBody(simple("${body.text}"))
		.to("smtps://{{demo.integration.smtp.host}}?username={{demo.integration.smtp.username}}&password={{demo.integration.smtp.password}}")
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(204));
    	
	}
}
