package com.redhat.consulting.fuse.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.redhat.consulting.fuse.entity.CountryEntity;
import com.redhat.consulting.fuse.entity.PersonEntity;
import com.redhat.consulting.fuse.entity.StateEntity;
import com.redhat.consulting.fuse.model.PersonModel;

@Component
public class RegisterPersonProcessor implements Processor {
	
	private static Logger LOGGER = LoggerFactory.getLogger(RegisterPersonProcessor.class);
	
	
	@Override
	public void process(Exchange exchange) throws Exception {
	
	
		
		PersonModel model = exchange.getIn().getBody(PersonModel.class);		
		
		LOGGER.info("### Model :: " + model.toString());
		
		
		PersonEntity entity = new PersonEntity();
		entity.setName(model.getNome());
		entity.setAddress2(model.getComplemento());
		entity.setCity(model.getCidade());
		entity.setCountry(new CountryEntity("MX"));
		entity.setEmail(model.getEmail());
		entity.setEndereco(model.getEndereco());
		entity.setId(null);
		entity.setMobile(model.getCelular());
		entity.setSocialSecuriry(model.getCpf());
		entity.setState(new StateEntity(2));
		entity.setZipCode(model.getCep());
		
		LOGGER.info("### Entity :: " + entity.toString());
		
		exchange.getIn().setBody(entity, PersonEntity.class);
		
	}	
	
}
