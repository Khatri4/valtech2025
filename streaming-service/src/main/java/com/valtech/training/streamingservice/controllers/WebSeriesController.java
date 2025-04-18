package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.services.WebSeriesService;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@RestController
@RequestMapping("/api/v1/webseries")
public class WebSeriesController {

	@Autowired
	private WebSeriesService webService;
	
	@PostMapping("/")
	public WebSeriesVO saveWebSeries(@RequestBody WebSeriesVO wsvo) {
		return webService.saveOrUpdateWebSeries(wsvo);
	}
	
	@GetMapping("/")
	public List<WebSeriesVO> getAllWebSeries(){
		return webService.getAll();
	}
}
