package org.alohome.rates.model;

import java.util.List;

public class RatesRequest {

	private AddressInfo from;
	private AddressInfo to;
	private String packageType = "PACKAGE";
	private List<PackageInfo> lineItems;
	private String unitOfMeasurement = "IMPERIAL";
	private String shipDate;
	
	public String getPackageType() {
		return packageType;
	}
	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}
	public AddressInfo getFrom() {
		return from;
	}
	public void setFrom(AddressInfo from) {
		this.from = from;
	}
	public AddressInfo getTo() {
		return to;
	}
	public void setTo(AddressInfo to) {
		this.to = to;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public List<PackageInfo> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<PackageInfo> lineItems) {
		this.lineItems = lineItems;
	}
}
