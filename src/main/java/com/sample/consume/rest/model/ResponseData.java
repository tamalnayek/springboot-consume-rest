package com.sample.consume.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
@XmlRootElement
public class ResponseData {
	private String responseStatus;
	private QueryDescribe queryDescribe;
	private ResponseDetails responseDetails;
	private List<Document> data;
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public QueryDescribe getQueryDescribe() {
		return queryDescribe;
	}
	public void setQueryDescribe(QueryDescribe queryDescribe) {
		this.queryDescribe = queryDescribe;
	}
	public ResponseDetails getResponseDetails() {
		return responseDetails;
	}
	public void setResponseDetails(ResponseDetails responseDetails) {
		this.responseDetails = responseDetails;
	}
	public List<Document> getData() {
		return data;
	}
	public void setData(List<Document> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseData [responseStatus=" + responseStatus + ", queryDescribe=" + queryDescribe
				+ ", responseDetails=" + responseDetails + ", data=" + data + "]";
	}

	
}
