package com.sample.consume.rest.service;

import java.io.File;
import java.io.IOException;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sample.consume.rest.model.UserResponse;

@Service
public class UserService {

	private static final String EXTERNAL_FILE_PATH = "C:/My WorkSpace/File-Download-Example/";

	public UserResponse getUserList(String pageNo) {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		// RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		// headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)
		// AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<UserResponse> response = restTemplate.exchange("https://reqres.in/api/users?page=" + pageNo,
				HttpMethod.GET, entity, UserResponse.class);
		
		// Generate and save Object Into JSON file
		this.createJsonFile(response.getBody());
		// Generate and save Object Into XML file
		this.createXMLFile(response.getBody());
		
		return response.getBody();

		/*
		 * CloseableHttpClient httpClient = HttpClients.custom()
		 * .setSSLHostnameVerifier(new NoopHostnameVerifier()) .build();
		 * HttpComponentsClientHttpRequestFactory requestFactory = new
		 * HttpComponentsClientHttpRequestFactory();
		 * requestFactory.setHttpClient(httpClient); RestTemplate restTemplate = new
		 * RestTemplate(requestFactory); Object result = restTemplate.getForObject(
		 * "https://api.hearthstonejson.com/v1/19776/enUS/cards.json", Object.class);
		 * 
		 */

	}

	/*
	 * Generate Object to JSON file.
	 * https://www.baeldung.com/jackson-convert-xml-json
	 */
	private void createJsonFile(UserResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		File jsonFile = new File(EXTERNAL_FILE_PATH+"data.json");
		try {
			mapper.writeValue(jsonFile, response);
			System.out.println("**JSON File saved ****");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Generate Object to XML file. 
	 * https://www.baeldung.com/jackson-xml-serialization-and-deserialization 
	 * OR
	 * https://howtodoinjava.com/jaxb/write-object-to-xml/
	 */
	private void createXMLFile(UserResponse response) {
		XmlMapper xmlMapper = new XmlMapper();
		File xmlFile = new File(EXTERNAL_FILE_PATH + "data.xml");
		try {
			xmlMapper.writeValue(xmlFile, response);
			System.out.println("**XML File saved ****");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
