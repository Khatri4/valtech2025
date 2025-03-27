package com.valtech.training.streamingservice.entities;

import jakarta.persistence.Entity;

@Entity
public class WebSeries extends Content {
	
	private int numOfEpisodes;
	private int durationPerEpisode;
	
	public WebSeries() {}
	public WebSeries(String name, String genre, String language, int costPerView, int numOfEpisodes,
			int durationPerEpisode) {
		super(name, genre, language, costPerView);
		this.numOfEpisodes = numOfEpisodes;
		this.durationPerEpisode = durationPerEpisode;
	}

	
	public int getNumOfEpisodes() {
		return numOfEpisodes;
	}
	public void setNumOfEpisodes(int numOfEpisodes) {
		this.numOfEpisodes = numOfEpisodes;
	}
	public int getDurationPerEpisode() {
		return durationPerEpisode;
	}
	public void setDurationPerEpisode(int durationPerEpisode) {
		this.durationPerEpisode = durationPerEpisode;
	}
	
}
