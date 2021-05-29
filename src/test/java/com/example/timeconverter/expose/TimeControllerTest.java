package com.example.timeconverter.expose;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.timeconverter.business.ConvertTimeService;
import com.fasterxml.jackson.core.JsonProcessingException;

@WebMvcTest(TimeController.class)
public class TimeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ConvertTimeService convertTimeService;

	private static Map<String, String> postRequest = new HashMap<>();

	@BeforeAll
	public static void setup() throws JsonProcessingException {

		postRequest.put("hour", "15:00:00");
		postRequest.put("timezone", "-2");
	}

	@Test
	public void convertTime_completeFields() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/timeconverter/v1/hours")
				.param("hour", postRequest.get("hour"))
				.param("timezone", postRequest.get("timezone")))
		.andExpect(status().isOk()).andReturn();
	}
	
}
