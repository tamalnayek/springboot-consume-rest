package com.sample.consume.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public class VaultAuth {
	
	private String responseStatus;
	private String sessionId;
	private String userId;
	private String vaultId;
	private VaultIds vaultIds;
	
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getVaultId() {
		return vaultId;
	}
	public void setVaultId(String vaultId) {
		this.vaultId = vaultId;
	}
	public VaultIds getVaultIds() {
		return vaultIds;
	}
	public void setVaultIds(VaultIds vaultIds) {
		this.vaultIds = vaultIds;
	}
	
	@Override
	public String toString() {
		return "VaultAuth [responseStatus=" + responseStatus + ", sessionId=" + sessionId + ", userId=" + userId
				+ ", vaultId=" + vaultId + ", vaultIds=" + vaultIds + "]";
	}
	
	}
