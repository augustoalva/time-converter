package com.example.timeconverter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeResponse {

	private String time;

	@JsonProperty("timezone")
	private String timeZone;

	@JsonProperty("zoneid")
	private String zoneId;

	public TimeResponse(String time, String timeZone, String zoneId) {
		super();
		this.time = time;
		this.timeZone = timeZone;
		this.zoneId = zoneId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

}
