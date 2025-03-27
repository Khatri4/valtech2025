package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.WebSeriesVO;

public interface WebSeriesService {

	WebSeriesVO saveOrUpdateWebSeries(WebSeriesVO wsvo);

	WebSeriesVO getWebSeries(long id);

	List<WebSeriesVO> getAll();

	List<WebSeriesVO> getWebSeriesByNumOfEpisodes(int num);

	List<WebSeriesVO> getWebSeriesByDurationPerEpisode(int duration);

}