package com.sample.consume.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.consume.rest.model.VaultAuth;
import com.sample.consume.rest.service.VaultAPIServices;

@RestController
public class VaultAPIController {
	
	@Autowired
	private VaultAPIServices vaultService;
	
	@PostMapping(value = "/vault/auth", produces = { "application/json", "application/xml" })
	public VaultAuth getAuthorization() {
		return vaultService.getAuthorization();
	}
	
	/*
	@RequestMapping(value = "/template/products")
	   public String getProductList() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("
	         http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
	  }
	  // Handle POST call.
	@RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String createProducts(@RequestBody Product product) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
      
      return restTemplate.exchange(
         "http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
   }
   
   @RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
   public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
      
      return restTemplate.exchange(
         "http://localhost:8080/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
   }
   
     @RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
   public String deleteProduct(@PathVariable("id") String id) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<Product> entity = new HttpEntity<Product>(headers);
      
      return restTemplate.exchange(
         "http://localhost:8080/products/"+id, HttpMethod.DELETE, entity, String.class).getBody();
   }
   
   // Another study link ...
   
   RestTemplate restTemplate = new RestTemplate();
	String fooResourceUrl  = "http://localhost:8080/spring-rest/foos";
	ResponseEntity<String> response  = restTemplate.getForEntity(fooResourceUrl + "/1", request, String.class);
	assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	
	ObjectMapper mapper = new ObjectMapper();
	JsonNode root = mapper.readTree(response.getBody());
	JsonNode name = root.path("name");
	assertThat(name.asText(), notNullValue());
	
	Foo foo = restTemplate.getForObject(fooResourceUrl + "/1", Foo.class);
	Foo foo = restTemplate.postForObject(fooResourceUrl, request, Foo.class);
	
	URI location = restTemplate.postForLocation(fooResourceUrl, request);
  
	HttpHeaders httpHeaders = restTemplate.headForHeaders(fooResourceUrl);
	assertTrue(httpHeaders.getContentType().includes(MediaType.APPLICATION_JSON));
	
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	
	MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
	map.add("id", "1");
	HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
	
	//Configure Timeout..
	RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
 	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
    int timeout = 5000;
    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
    clientHttpRequestFactory.setConnectTimeout(timeout);
    return clientHttpRequestFactory;
	}
	// https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example/

	private static void updateEmployee()
	{
    final String uri = "http://localhost:8080/springrestexample/employees/{id}";     
    Map<String, String> params = new HashMap<String, String>();
    params.put("id", "2");     
    EmployeeVO updatedEmployee = new EmployeeVO(2, "New Name", "Gilly", "test@email.com");
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.put ( uri, updatedEmployee, params);
    
    Map<String, String> params = new HashMap<String, String>();
    params.put("id", "2");     
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.delete ( uri,  params );
    
    
	}
	
	 */
	
	
	   
}
