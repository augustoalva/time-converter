package com.example.timeconverter.business;

import org.springframework.http.ResponseEntity;

import com.example.timeconverter.model.Response;

public interface ConvertTimeService {

	ResponseEntity<Response> getLocalHour(String hour, String timezone);
}
