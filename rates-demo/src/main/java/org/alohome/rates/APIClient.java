package org.alohome.rates;

import org.alohome.rates.model.CreateShipmentRequest;
import org.alohome.rates.model.CreateShipmentResponse;
import org.alohome.rates.model.RatesRequest;
import org.alohome.rates.model.RatesResponse;
import org.alohome.rates.model.RequestAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class APIClient {

	@Autowired
    private Util util;

	@Autowired
    private Environment config;

	@Autowired
	private RestTemplate restClient;

	private <T> String getJsonFromAPIEndpoint(String endpoint, T request) {
		String uri = config.getProperty("APIBaseURL") + endpoint;
		ResponseEntity<String> resp = null;
		do {
			resp = restClient.postForEntity(uri, request, String.class);
			if (resp.getStatusCode().is3xxRedirection()) {
				uri = resp.getHeaders().getFirst("Location");
			}
		} while (resp.getStatusCode().is3xxRedirection());
		return resp.getBody();
	}

	public RatesResponse getRates(RatesRequest ratesRequest) throws RestClientException {
		String ratesJson = getJsonFromAPIEndpoint("/rates", ratesRequest);
		RatesResponse ratesResponse = util.getRatesResponseFromJson(ratesJson);
		if (ratesResponse == null)
			throw new RequestAPIException(421, "ShipTime rates API return value error", null);
		return ratesResponse;
	}

	public CreateShipmentResponse createShipment(CreateShipmentRequest shipRequest) throws RestClientException {
		String shipmentJson = getJsonFromAPIEndpoint("/shipments", shipRequest);
		CreateShipmentResponse shipmentResponse = util.getShipmentResponseFromJson(shipmentJson);
		if (shipmentResponse == null)
			throw new RequestAPIException(421, "ShipTime shipments API return value error", null);
		return shipmentResponse;
	}

	public byte[] downloadLabelPdf(String labelUrl) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);

		ResponseEntity<byte[]> resp = null;
		do {
			resp = restClient.exchange(labelUrl, HttpMethod.GET, new HttpEntity<>(headers), byte[].class);
			if (resp.getStatusCode().is3xxRedirection()) {
				labelUrl = resp.getHeaders().getFirst("Location");
			}
		} while (resp.getStatusCode().is3xxRedirection());

		return resp.getBody();
	}
}
