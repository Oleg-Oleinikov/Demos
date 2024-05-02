package org.alohome.rates.model;

import org.springframework.web.client.RestClientException;

public class RequestAPIException extends RestClientException {

	private static final long serialVersionUID = 11L;
	private int statusCode;
	private String errorBody;

	public RequestAPIException(String errorMessage) {
		super(errorMessage);
		this.errorBody = "";
	}

	public RequestAPIException(int statusCode, String errorMessage, String errorBody) {
		super(errorMessage);
		this.statusCode = statusCode;
		this.errorBody = errorBody;
	}

	public int getStatusCode() {
		return statusCode;
	}
	public String getErrorBody() {
		return errorBody;
	}
}
