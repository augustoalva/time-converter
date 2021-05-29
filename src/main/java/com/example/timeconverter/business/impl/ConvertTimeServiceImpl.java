package com.example.timeconverter.business.impl;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.timeconverter.business.ConvertTimeService;
import com.example.timeconverter.model.Response;
import com.example.timeconverter.model.TimeResponse;
import com.example.timeconverter.util.Constants;

@Service
public class ConvertTimeServiceImpl implements ConvertTimeService {

	@Override
	public ResponseEntity<Response> getLocalHour(String hour, String timezone) {

		String localHour = "";
		String zoneId = "";

		try {
			String[] splitHour = hour.split(Constants.SPLIT_CHAR);

			ZoneId requestZoneId = ZoneId.of(timezone);
			ZoneId localZoneId = ZoneId.of(Constants.LOCAL_TIMEZONE);

			LocalDateTime time1 = LocalDateTime.now(requestZoneId);
			time1 = time1.withHour(Integer.valueOf(splitHour[0])).withMinute(Integer.valueOf(splitHour[1]))
					.withSecond(Integer.valueOf(splitHour[2]));

			ZonedDateTime requestZonedDateTime = time1.atZone(requestZoneId);

			ZonedDateTime localZonedDateTime = requestZonedDateTime.withZoneSameInstant(localZoneId);

			localHour = DateTimeFormatter.ofPattern(Constants.FORMAT_HOUR).format(localZonedDateTime);
			zoneId = localZoneId.getId();

		} catch (DateTimeException e) {
			e.printStackTrace();
			throw e;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}

		Response response = new Response();
		response.setResponse(new TimeResponse(localHour, Constants.TIMEZONE_UTC, zoneId));

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
