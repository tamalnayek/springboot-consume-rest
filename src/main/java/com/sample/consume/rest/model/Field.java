package com.sample.consume.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
@XmlRootElement
public class Field {

	private String label;
	private String type;
	private String required;
	private String name;
	private int max_length;
	private int min_value;
	private int scale;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRequired() {
		return required;
	}
	public void setRequired(String required) {
		this.required = required;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMax_length() {
		return max_length;
	}
	public void setMax_length(int max_length) {
		this.max_length = max_length;
	}
	public int getMin_value() {
		return min_value;
	}
	public void setMin_value(int min_value) {
		this.min_value = min_value;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	@Override
	public String toString() {
		return "Field [label=" + label + ", type=" + type + ", required=" + required + ", name=" + name
				+ ", max_length=" + max_length + ", min_value=" + min_value + ", scale=" + scale + "]";
	}
		
}
