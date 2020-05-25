package com.sample.consume.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
@XmlRootElement
public class QueryDescribe {
	private Object_L object;
	private List<Field> fields;
	public Object_L getObject() {
		return object;
	}
	public void setObject(Object_L object) {
		this.object = object;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	@Override
	public String toString() {
		return "QueryDescribe [object=" + object + ", fields=" + fields + "]";
	}
	
}
