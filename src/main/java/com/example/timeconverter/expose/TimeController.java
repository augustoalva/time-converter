package com.example.timeconverter.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.timeconverter.business.ConvertTimeService;
import com.example.timeconverter.model.Response;

@RestController
@Validated
@CrossOrigin(origins = "*")
@RequestMapping("/timeconverter/v1/hours")
public class TimeController {

	@Autowired
	private ConvertTimeService convertTimeService;

	@PostMapping()
	public ResponseEntity<Response> convertHour(@RequestParam String hour, @RequestParam String timezone) {

		return convertTimeService.getLocalHour(hour, timezone);
	}
}
