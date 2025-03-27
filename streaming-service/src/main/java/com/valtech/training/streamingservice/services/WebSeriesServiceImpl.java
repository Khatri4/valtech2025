package com.valtech.training.streamingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.repos.WebSeriesRepo;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class WebSeriesServiceImpl implements WebSeriesService {
	
	@Autowired
	private WebSeriesRepo webRepo;
	
	@Override
	public WebSeriesVO saveOrUpdateWebSeries(WebSeriesVO wsvo) {
		return WebSeriesVO.from(webRepo.save(wsvo.to()));
	}
	
	@Override
	public WebSeriesVO getWebSeries(long id) {
		return WebSeriesVO.from(webRepo.getReferenceById(id));
	}
	
	@Override
	public List<WebSeriesVO> getAll(){
		return WebSeriesVO.from(webRepo.findAll());
	}
	
	@Override
	public List<WebSeriesVO> getWebSeriesByNumOfEpisodes(int num){
		return WebSeriesVO.from(webRepo.findAllByNumOfEpisodes(num));
	}
	
	@Override
	public List<WebSeriesVO> getWebSeriesByDurationPerEpisode(int duration){
		return WebSeriesVO.from(webRepo.findAllByDurationPerEpisode(duration));
	}
	
	

}
