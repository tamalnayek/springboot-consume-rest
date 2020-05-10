package com.smaple.consume.rest.utils;

public class RestConstant {
	
	public static final String VAULT_URL = "https://sb-pmi-qualityone.veevavault.com/api";
	public static final String VAULT_VERSION = "/v19.3";
//	public static final String AUTH_URL = "/auth";

	
	
	public static String urlBuilder(String url) {		
		return VAULT_URL.concat(VAULT_VERSION).concat(url);
	}
}
