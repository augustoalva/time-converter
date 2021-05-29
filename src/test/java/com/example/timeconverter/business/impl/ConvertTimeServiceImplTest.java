package com.example.timeconverter.business.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.DateTimeException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.timeconverter.model.Response;
import com.fasterxml.jackson.core.JsonProcessingException;

@ExtendWith(MockitoExtension.class)
public class ConvertTimeServiceImplTest {

	@InjectMocks
	private ConvertTimeServiceImpl convertTimeServiceImpl;

	private static final String TAG_HOUR = "hour";
	private static final String TAG_TIMEZONE = "timezone";

	private static Map<String, String> postRequest = new HashMap<>();
	private static Map<String, String> postBadHourRequest = new HashMap<>();
	private static Map<String, String> postBadTimeZoneRequest = new HashMap<>();
	private static Map<String, String> postEmptyHourRequest = new HashMap<>();
	private static Map<String, String> postEmptyTimezoneRequest = new HashMap<>();

	@BeforeAll
	public static void setup() throws JsonProcessingException {

		postRequest.put(TAG_HOUR, "15:00:00");
		postRequest.put(TAG_TIMEZONE, "-2");

		postBadHourRequest.put(TAG_HOUR, "35:00:00");
		postBadHourRequest.put(TAG_TIMEZONE, "-2");

		postBadTimeZoneRequest.put(TAG_HOUR, "15:00:00");
		postBadTimeZoneRequest.put("timezone", "a");

		postEmptyHourRequest.put(TAG_HOUR, "");
		postEmptyHourRequest.put(TAG_TIMEZONE, "+2");

		postEmptyTimezoneRequest.put(TAG_HOUR, "10:00:00");
		postEmptyTimezoneRequest.put(TAG_TIMEZONE, "");
	}

	@Test
	public void convertTime_completeFields() throws Exception {

		ResponseEntity<Response> response = convertTimeServiceImpl.getLocalHour(postRequest.get(TAG_HOUR),
				postRequest.get(TAG_TIMEZONE));

		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void convertTime_badHour() throws Exception {

		excepResponse(postBadHourRequest);
	}

	@Test
	public void convertTime_badTimeZone() throws Exception {

		excepResponse(postBadTimeZoneRequest);
	}

	@Test
	public void convertTime_emptyTimeZone() throws Exception {

		excepResponse(postEmptyTimezoneRequest);
	}

	@Test
	public void convertTime_emptyHour() throws Exception {

		assertThrows(NumberFormatException.class, () -> {
			convertTimeServiceImpl.getLocalHour(postEmptyHourRequest.get(TAG_HOUR),
					postEmptyHourRequest.get(TAG_TIMEZONE));
		});
	}

	private void excepResponse(Map<String, String> request) throws Exception {

		assertThrows(DateTimeException.class, () -> {
			convertTimeServiceImpl.getLocalHour(request.get(TAG_HOUR), request.get(TAG_TIMEZONE));
		});
	}
}
