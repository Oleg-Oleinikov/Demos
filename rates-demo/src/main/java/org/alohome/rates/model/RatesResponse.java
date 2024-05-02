package org.alohome.rates.model;

import java.util.List;

public class RatesResponse {

	private List<QuoteModel> availableRates;
	private List<String> messages;

	public QuoteModel getQuoteById(String id) {
		return availableRates.stream().filter(quote -> quote.getQuoteId().equals(id)).findAny().orElse(null);
	}

	public List<QuoteModel> getAvailableRates() {
		return availableRates;
	}
	public void setAvailableRates(List<QuoteModel> availableRates) {
		this.availableRates = availableRates;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
}
