package com.Interview_Assessment.pages;

public enum Locations {
	
	
	AnnaNagar("Anna Nagar"),
	Mylapore("Mylapore"),
	TNagar("T Nagar");

	private String loc;
	Locations(String loc) {
		this.loc = loc;
	}
	
	public String getLocation() {
		return loc;
	}
	
}
	
	

