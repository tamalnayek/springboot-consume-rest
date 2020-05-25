package com.sample.consume.rest.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonIOException;
import com.sample.consume.rest.model.ResponseData;
import com.sample.consume.rest.model.VaultAuth;
import com.sample.consume.rest.template.JsonFileWriter;
import com.sample.consume.rest.template.VaultRestTemplate;
import com.sample.consume.rest.template.XmlFileWriter;
import com.smaple.consume.rest.utils.RestConstant;

@Service
public class VaultAPIServices {

	private static final Logger log = LoggerFactory.getLogger(VaultAPIServices.class);

	@Autowired
	private VaultRestTemplate vaultRestTemplate;
	@Autowired
	private JsonFileWriter jsonFileWriter;
	@Autowired
	private XmlFileWriter xmlFileWriter;

	private static final String EXTERNAL_FILE_PATH_JSON = "C:/My WorkSpace/File-Download-Example/auth.json";
	private static final String EXTERNAL_FILE_PATH_XML = "C:/My WorkSpace/File-Download-Example/auth.xml";

	private static String SESSION_ID = "";

	public VaultAuth getAuthorization() {
		String authURL = RestConstant.urlBuilder("/auth");
		RestTemplate restTemplate = vaultRestTemplate.prepareRestTemplateForHTTPS();

		Map<String, String> reqMap = new HashMap<String, String>();
		reqMap.put("username", "int-test@sb-pmi.com");
		reqMap.put("password", "Veeva1234");

		HttpHeaders headers = vaultRestTemplate.buildRequestHeader(true, true);
		HttpEntity<MultiValueMap<String, String>> httpEntity = vaultRestTemplate.buildRequestBody(reqMap, headers);

		ResponseEntity<VaultAuth> result = restTemplate.exchange(authURL, HttpMethod.POST, httpEntity, VaultAuth.class);

		// check response status.
		if (result.getStatusCode() == HttpStatus.OK) {
			System.out.println("Login Successful" + result.getBody());
			try {
				VaultAuth auth = result.getBody();
				// Set Session ID for further use.
				SESSION_ID = auth.getSessionId();
				// Write Object to files ( json and xml)
				jsonFileWriter.writeJsonFile(auth, EXTERNAL_FILE_PATH_JSON);
				xmlFileWriter.convertObjectToXML(auth, EXTERNAL_FILE_PATH_XML);

			} catch (JsonIOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Login Failed");
		}

		return result.getBody();

		// return restTemplate.getVaultAuthorized();
	}

	public ResponseData getQueryData(String query) {
		System.out.println("query =" + query + " Session :" + SESSION_ID);
		String queryURL = RestConstant.urlBuilder("/query");
		RestTemplate restTemplate = vaultRestTemplate.prepareRestTemplateForHTTPS();

		HttpHeaders headers = vaultRestTemplate.buildRequestHeader(true, true);
		headers.set("X-VaultAPI-DescribeQuery", "true");
		headers.set("Authorization", SESSION_ID);

		Map<String, String> reqMap = new HashMap<String, String>();
		reqMap.put("q", query);

		HttpEntity<MultiValueMap<String, String>> httpEntity = vaultRestTemplate.buildRequestBody(reqMap, headers);
		ResponseEntity<ResponseData> result = restTemplate.exchange(queryURL, HttpMethod.POST, httpEntity,
				ResponseData.class);

		if (result.getStatusCode() == HttpStatus.OK) {
			System.out.println("Success :");
		} else {
			System.out.println("Error :");
		}
		return result.getBody();
	}

}
