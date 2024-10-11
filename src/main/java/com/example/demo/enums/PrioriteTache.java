package com.example.demo.enums;

public enum PrioriteTache {
	
	FAIBLE ("faible"),
	MOYENNE ("moyenne"),
	HAUTE ("haute");

	
	private String value;

	private PrioriteTache(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
