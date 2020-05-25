package com.sample.consume.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.consume.rest.model.ResponseData;
import com.sample.consume.rest.model.VaultAuth;
import com.sample.consume.rest.service.VaultAPIServices;

@RestController
public class VaultAPIController {
	
	@Autowired
	private VaultAPIServices vaultService;
	
	private final AtomicLong counter = new AtomicLong(); //counter.incrementAndGet();
	
	@PostMapping(value = "/vault/auth", produces = { "application/json", "application/xml" }, 
			consumes = {"application/x-www-form-urlencoded"})
	public VaultAuth getAuthorization() {
		System.out.println("Counter call from VaultAPIController ::"+counter.incrementAndGet());
		return vaultService.getAuthorization();
	}
	
	@PostMapping(value = "/vault/query", produces = { "application/json", "application/xml" }, 
			consumes = {"application/x-www-form-urlencoded"})
	public ResponseData getQueryData(@RequestParam(value = "query") String query) {
		System.out.println("Counter call from VaultAPIController ::"+counter.incrementAndGet());
		return vaultService.getQueryData(query);
	}
	
	

	   
}
