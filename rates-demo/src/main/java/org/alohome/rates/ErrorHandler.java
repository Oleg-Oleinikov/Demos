package org.alohome.rates;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.alohome.rates.model.RequestAPIException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;

public class ErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return response.getStatusCode().is5xxServerError() || 
				response.getStatusCode().is4xxClientError();
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is5xxServerError()) {
            throw new RestClientException("ShipTime Server error: " + response.getStatusCode().value());
        } else if (response.getStatusCode().is4xxClientError()) {
    			String errorBody = new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8);
            throw new RequestAPIException(response.getStatusCode().value(), "ShipTime API error", errorBody);
        }
	}

}
