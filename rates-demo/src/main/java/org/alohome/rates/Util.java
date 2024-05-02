package org.alohome.rates;

import java.util.Collections;
import java.util.List;

import org.alohome.rates.model.CreateShipmentResponse;
import org.alohome.rates.model.QuoteModel;
import org.alohome.rates.model.RatesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

	private final static Logger log = LoggerFactory.getLogger(Util.class);

	@Autowired
    private ObjectMapper jsonMapper;

	private <T> T readJsonToObject(String json, Class<T> returnType) {
		T resultObject = null;
		try {
			resultObject = jsonMapper.readValue(json, returnType);
		} catch (JsonProcessingException e) {
			log.error("Error while converting " + returnType.getSimpleName() + " from JSON", e);
		}
		return resultObject;
	}

	public RatesResponse getRatesResponseFromJson(String json) {
		return readJsonToObject(json, RatesResponse.class);
	}

	public CreateShipmentResponse getShipmentResponseFromJson(String json) {
		return readJsonToObject(json, CreateShipmentResponse.class);
	}

	public void sortRateQuotes(List<QuoteModel> availableRates) {
		Collections.sort(availableRates);
	}
}
