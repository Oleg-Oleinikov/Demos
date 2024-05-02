package org.alohome.rates.model;

public class MoneyAmount {

	private String currency;
	private Integer amount;

	public String getAmountFormatted() {
		return amount == null ? "" : String.format("%.2f", 0.01*amount);
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
