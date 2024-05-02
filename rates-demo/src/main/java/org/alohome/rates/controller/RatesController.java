package org.alohome.rates.controller;

import org.alohome.rates.model.RequestAPIException;
import org.alohome.rates.model.Selected;
import org.alohome.rates.model.RatesRequest;
import org.alohome.rates.model.RatesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestClientException;

/**
 * Rates controller
 * @author Oleg Oleinikov
 */
@Controller
@SessionAttributes({"ratesRequest","ratesResponse","selected"})
public class RatesController extends AbstractController {

	private final static Logger log = LoggerFactory.getLogger(RatesController.class);

    @GetMapping("/")
	public String initialForm(Model model) {
		return userResponse("initial_data", null, null, model);
	}

	@PostMapping("/rates")
	public String getRates(RatesRequest ratesRequest, Model model) {
		model.addAttribute("ratesRequest", ratesRequest);

		RatesResponse rateResponse = null;
		try {
			rateResponse = client.getRates(ratesRequest);
		} catch (RequestAPIException e) {
			return userResponse("initial_data", e.getMessage(), e.getErrorBody(), model);
		} catch (RestClientException e) {
			log.error("API is unavailable");
			e.printStackTrace();
			return userResponse("error", e.getMessage(), null, model);
		}

		util.sortRateQuotes(rateResponse.getAvailableRates());

		model.addAttribute("ratesResponse", rateResponse).addAttribute("selected", new Selected());
		return userResponse("rate_select", null, null, model);
	}
}
