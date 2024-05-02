package org.alohome.rates.model;

public class Surcharge {

	private MoneyAmount price;
	private String code;
	private String name;

	public MoneyAmount getPrice() {
		return price;
	}
	public void setPrice(MoneyAmount price) {
		this.price = price;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
