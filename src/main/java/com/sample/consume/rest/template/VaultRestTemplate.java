package com.sample.consume.rest.template;

import java.util.Arrays;
import java.util.Map;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.sample.consume.rest.model.VaultAuth;
import com.smaple.consume.rest.utils.RestConstant;

@Component
public class VaultRestTemplate {

	private static final Logger log = LoggerFactory.getLogger(VaultRestTemplate.class);

	/*
	 * @Autowired private RestTemplate restTemplate;
	 * 
	 * @Bean public RestTemplate restTemplate(RestTemplateBuilder builder) { return
	 * builder.build(); }
	 */
	public RestTemplate prepareRestTemplateForHTTPS() {
		// Call HTTPS end-point from HTTP.
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		return new RestTemplate(requestFactory);
	}

	public HttpHeaders buildRequestHeader(boolean acceptFlg, boolean contentTypeFlg) {
		// create headers
		HttpHeaders headers = new HttpHeaders();

		// set `accept` header
		if (acceptFlg)
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		// set `content-type` header
		if (contentTypeFlg)
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		return headers;
	}
	
	public HttpEntity<MultiValueMap<String, String>> buildRequestBody(Map<String, String> reqMap, HttpHeaders headers) {
		// request body parameters
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		
		for(Map.Entry<String, String> entry : reqMap.entrySet()) {
			form.add(entry.getKey(),entry.getValue());
		}
		// build the request
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(form, headers);
		
		return entity;
	}

	
	public VaultAuth getVaultAuthorized() {
		String authURL = RestConstant.urlBuilder("/auth");

		RestTemplate restTemplate = this.prepareRestTemplateForHTTPS();
		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `accept` header
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		// request body parameters
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("username", "int-test@sb-pmi.com");
		form.add("password", "Veeva1234");

		// build the request
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(form, headers);
		// ResponseEntity<VaultAuth> result = restTemplate.postForEntity(authURL,
		// entity, VaultAuth.class);
		ResponseEntity<VaultAuth> result = restTemplate.exchange(authURL, HttpMethod.POST, entity, VaultAuth.class);
		log.info("Response :" + result.getBody().toString());

		// check response
		if (result.getStatusCode() == HttpStatus.OK) {
			System.out.println("Login Successful" + result.getBody().getSessionId());
		} else {
			System.out.println("Login Failed");
		}

		return result.getBody();
	}
}
