package com.valtech.training.streamingservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.streamingservice.entities.WebSeries;

public record WebSeriesVO(long id, String name, String genre, String language, int costPerView, int numOfEpisodes, int durationPerEpisode) {

	public static WebSeriesVO from(WebSeries web) {
		return new WebSeriesVO(web.getId(), web.getName(), web.getGenre(), web.getLanguage(), web.getCostPerView(), web.getNumOfEpisodes(), web.getDurationPerEpisode());
	}
	
	public static List<WebSeriesVO> from(List<WebSeries> web){
		return web.stream().map(w -> WebSeriesVO.from(w)).collect(Collectors.toList());
	}
	
	public WebSeries to() {
		return new WebSeries(name, genre, language, costPerView, numOfEpisodes, durationPerEpisode);
	}
}
