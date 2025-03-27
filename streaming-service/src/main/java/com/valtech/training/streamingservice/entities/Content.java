package com.valtech.training.streamingservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;


@MappedSuperclass
public class Content {
	
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "content_id")
	@SequenceGenerator(name = "content_id", sequenceName = "content_id", allocationSize = 1)
	private long id;
	private String name;
	private String genre;
	private String language;
	private int costPerView;
	
	
	public Content() {}
	public Content(long id,String name, String genre, String language, int costPerView) {
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.language = language;
		this.costPerView = costPerView;
	}
	public Content(String name, String genre, String language, int costPerView) {
		this.name = name;
		this.genre = genre;
		this.language = language;
		this.costPerView = costPerView;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getCostPerView() {
		return costPerView;
	}
	public void setCostPerView(int costPerView) {
		this.costPerView = costPerView;
	}

	
	
	
	
}
