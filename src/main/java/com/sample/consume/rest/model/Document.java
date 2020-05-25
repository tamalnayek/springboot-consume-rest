package com.sample.consume.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
@XmlRootElement
public class Document {

	private int id;
	private String name__v;
	private String major_version_number__v;
	private String minor_version_number__v;
	private String status__v;
	private String version_modified_date__v;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName__v() {
		return name__v;
	}
	public void setName__v(String name__v) {
		this.name__v = name__v;
	}
	public String getMajor_version_number__v() {
		return major_version_number__v;
	}
	public void setMajor_version_number__v(String major_version_number__v) {
		this.major_version_number__v = major_version_number__v;
	}
	public String getMinor_version_number__v() {
		return minor_version_number__v;
	}
	public void setMinor_version_number__v(String minor_version_number__v) {
		this.minor_version_number__v = minor_version_number__v;
	}
	public String getStatus__v() {
		return status__v;
	}
	public void setStatus__v(String status__v) {
		this.status__v = status__v;
	}
	public String getVersion_modified_date__v() {
		return version_modified_date__v;
	}
	public void setVersion_modified_date__v(String version_modified_date__v) {
		this.version_modified_date__v = version_modified_date__v;
	}
		
}
