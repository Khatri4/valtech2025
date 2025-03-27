package com.valtech.training.registerservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.valtech.training.registerservice.vos.UserVO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterServiceTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testGetUserByValidId() throws Exception {
		mockMvc.perform(get("/api/v1/users/6")).andDo(print()).andExpect(content().json("{'id': 6, 'age': 22, 'email': 'jhgjh@gmail.com', 'isKid': false, 'mobile': '7768678', 'name': 'varnika', 'subId': 3}"))
		.andExpectAll(status().isOk());
	}
	
	
	@Test
	public void testByInvalidId() throws Exception{
		mockMvc.perform(get("/api/v1/users/15")).andDo(print()).andExpect(status().isNotFound());
	}
}
	