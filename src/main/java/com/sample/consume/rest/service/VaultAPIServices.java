package com.sample.consume.rest.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sample.consume.rest.SpringbootConsumeRestApplication;
import com.sample.consume.rest.model.Authorized;
import com.sample.consume.rest.model.VaultAuth;
import com.smaple.consume.rest.utils.RestConstant;

@Service
public class VaultAPIServices {
	
private static final Logger log = LoggerFactory.getLogger(SpringbootConsumeRestApplication.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public VaultAuth getAuthorization() {
		String authURL = RestConstant.urlBuilder("/auth");
		/*
		  VaultAuth vaultAuth = restTemplate.postForObject(authURL,new Authorized(),VaultAuth.class); 
		  log.info("Response :"+vaultAuth.toString());
		  return vaultAuth;
		 */
		
		HttpHeaders headers = new HttpHeaders();
	    //headers.setAccept(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED));
	    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	    ResponseEntity<VaultAuth> result = restTemplate.exchange(authURL, HttpMethod.POST, entity, VaultAuth.class);
	    log.info("Response :"+result.getBody().toString());
	    return result.getBody();
	    
	}
	
	

}
