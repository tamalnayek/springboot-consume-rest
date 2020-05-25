package com.sample.consume.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
@XmlRootElement
public class Object_L {

	private String name;
	private String label;
	private String label_plural;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getLabel_plural() {
		return label_plural;
	}
	public void setLabel_plural(String label_plural) {
		this.label_plural = label_plural;
	}
	@Override
	public String toString() {
		return "Object_L [name=" + name + ", label=" + label + ", label_plural=" + label_plural + "]";
	}
	
}
