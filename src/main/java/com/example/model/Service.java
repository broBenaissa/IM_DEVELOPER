package com.example.model;

public class Service {
	protected int id;
	protected String name;
	protected String description ;
	protected String price;
	
	

	public Service(int id, String name, String description, String price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	


	public Service(String name, String description, String price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setImage(String price) {
		this.price = price;
	}

}
