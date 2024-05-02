package org.alohome.rates.controller;

import org.alohome.rates.model.RequestAPIException;
import org.alohome.rates.model.Selected;
import org.alohome.rates.model.CreateShipmentRequest;
import org.alohome.rates.model.CreateShipmentResponse;
import org.alohome.rates.model.QuoteModel;
import org.alohome.rates.model.RatesRequest;
import org.alohome.rates.model.RatesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestClientException;

/**
 * Shipments controller
 * @author Oleg Oleinikov
 */
@Controller
@SessionAttributes({"ratesRequest","ratesResponse","selected"})
public class ShipmentsController  extends AbstractController {

	private final static Logger log = LoggerFactory.getLogger(ShipmentsController.class);

	@PostMapping("/shipments")
	public String createShipment(@ModelAttribute("ratesRequest") RatesRequest rateRequest, @ModelAttribute("ratesResponse") RatesResponse rateResponse,
			@ModelAttribute("selected") Selected selectedQuote, Model model, SessionStatus status) {

		QuoteModel shipQuote = rateResponse.getQuoteById(selectedQuote.getValue());
		if (shipQuote == null)
			return userResponse("rate_select", "Quote is not selected", null, model);
		CreateShipmentRequest shipRequest = buildShipmentRequest(rateRequest, shipQuote);
		CreateShipmentResponse shipmentResponse = null;
		try {
			shipmentResponse = client.createShipment(shipRequest);
		} catch (RequestAPIException e) {
			return userResponse("rate_select", e.getMessage(), e.getErrorBody(), model);
		} catch (RestClientException e) {
			log.error("API is unavailable");
			e.printStackTrace();
			return userResponse("error", e.getMessage(), null, model);
		}

		status.setComplete();

		model.addAttribute("shipmentResponse", shipmentResponse);
		return userResponse("success", null, null, model);
	}

	/** It is here to demonstrate a pattern.
	 * Usually it is a part of a general request builder class.
	 * @return a createShipmentRequest instance
	 */
	private CreateShipmentRequest buildShipmentRequest(RatesRequest rateRequest, QuoteModel shipQuote) {
		return new CreateShipmentRequest()
				.setRateRequest(rateRequest)
				.setCarrierId(shipQuote.getCarrierId())
				.setServiceId(shipQuote.getServiceId());
	}

	@PostMapping(value = "/label", produces = {MediaType.APPLICATION_PDF_VALUE})
	@ResponseBody
	public byte[] getPDFLabel(String labelUrl, Model model) {
		byte[] labelPdf = null;
		try {
			labelPdf = client.downloadLabelPdf(labelUrl);
		} catch (RestClientException e) {
			log.error("label PDF is unavailable", e);
		}
		return labelPdf;
	}
}
