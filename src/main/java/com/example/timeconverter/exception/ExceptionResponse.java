package com.example.timeconverter.exception;

public class ExceptionResponse {

	private String exceptionId;

	private String exceptionText;

	public String getExceptionId() {
		return exceptionId;
	}

	public String getExceptionText() {
		return exceptionText;
	}

	public ExceptionResponse(String exceptionId, String exceptionText) {
		super();
		this.exceptionId = exceptionId;
		this.exceptionText = exceptionText;
	}

}
