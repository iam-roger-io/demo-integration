package com.redhat.consulting.fuse.route;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestOperationParamDefinition;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redhat.consulting.fuse.entity.PeopleEntity;
import com.redhat.consulting.fuse.model.PersonModel;
import com.redhat.consulting.fuse.processor.RegisterPersonProcessor;

@Component
public class APICrud extends RouteBuilder {
	
	@Autowired
	private RegisterPersonProcessor registerPersonProcessor;
	
	
	@Override
	public void configure() throws Exception {
		
		rest("/crud")
		.produces("application/json")	
		
		.post("/person")
		.id("post-register-person")
		.produces("application/json")
		.type(com.redhat.consulting.fuse.model.PersonModel.class)
		.to("direct:register-person")
		.description("Insere ou atualiza os dados de uma pessoa")
		.apiDocs(true)
		.param()		
			.name("body").type(RestParamType.body).description("JSON com os dados da Pessoa").dataType("String").endParam()
		.responseMessage()
			.code(204).message("Nenhuma")			
		.endResponseMessage()
		.responseMessage()			
			.code(500).message("Erro interno")
		.endResponseMessage()		
		
		.get("/person")
		.consumes("application/json")
		.id("get-find-all-people")
		.outType(com.redhat.consulting.fuse.model.PersonModel.class)
		.to("direct:find-all-people")
		.description("Exibe um ARRAY de JSON com todas as pessoas cadastradas.")
		.apiDocs(true)
		.responseMessage()
			.code(200).message("Objeto JSON contendo so dados de uma pessoa").responseModel(PersonModel.class)			
		.endResponseMessage()
		.responseMessage()			
			.code(500).message("Erro interno")
		.endResponseMessage()			
		
		.get("/person/{id}")
		.id("get-find-person-by-id")
		.outType(com.redhat.consulting.fuse.model.PersonModel.class)
		.to("direct:find-person-by-id")		
		.description("Exibe os dados de uma pessoa baseado no seu ID")
		.apiDocs(true)
		.param()		
			.name("id").type(RestParamType.path).description("ID da pessoa a ser pesquisada").dataType("integer").endParam()
		.responseMessage()
			.code(200).message("Objeto JSON contendo so dados de uma pessoa").responseModel(PersonModel.class)			
		.endResponseMessage()
		.responseMessage()			
			.code(500).message("Erro interno")
		.endResponseMessage()		
		
		.delete("/person/{id}")
		.id("get-find-person-by-id")		
		.to("direct:delete-person")
		.description("Exclui uma pessoa do cadastro")
		.apiDocs(true)
		.param()		
			.name("id").type(RestParamType.query).description("ID da pessoa a ser removida").dataType("integer").endParam()
		.responseMessage()
			.code(204).message("Nenhuma")			
		.endResponseMessage()
		.responseMessage()			
			.code(500).message("Erro interno")
		.endResponseMessage();

		
		// ROUTES
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
		.toD("jpa://com.redhat.consulting.fuse.entity.PeopleEntity?nativeQuery=delete from people a where a.id = ${header.id}")		
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(204));
		   
    	
	}
}
