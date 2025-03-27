package com.valtech.training.resultservice.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.resultservice.vos.ResultVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ResultControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	
	@Test
	void test() {
		String url = "http://localhost:"+port+"/api/v1/results/5";
		ResultVO resVO = restTemplate.getForObject(url, ResultVO.class);
		
		assertEquals(4, resVO.score());
		
		System.out.println("Score is =========>>>>>>>>>>>>" + resVO.score());
	}

}
