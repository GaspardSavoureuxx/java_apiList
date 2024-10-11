package com.example.demo.enums;

public enum EtatTache {
	
	EN_COURS ("en cours"),
	TERMINE ("terminé");

	
	private String value;

	private EtatTache(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
