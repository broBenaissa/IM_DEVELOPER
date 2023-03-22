package com.example.model;

public class Projet {
	private int id;
	private String titre;
	private String description;
	private String url;
	
	public Projet() {}

	public Projet(int id, String titre, String description, String url) {
	    this.id = id;
	    this.titre = titre;
	    this.description = description;
	    this.url = url;
	}

	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}

	public String getTitre() {
	    return titre;
	}

	public void setTitre(String titre) {
	    this.titre = titre;
	}

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}

	public String getUrl() {
	    return url;
	}

	public void setUrl(String url) {
	    this.url = url;
	}

}
