package org.alohome.rates.model;

import java.util.List;

public class CreateShipmentResponse {

	private Integer shipId;
	private List<String> trackingNumbers;
	private String labelUrl;
	private String invoiceUrl;
	private String carrierTrackingUrl;
	private String pickupConfirmation;
	private List<String> messages;

	public Integer getShipId() {
		return shipId;
	}
	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}
	public List<String> getTrackingNumbers() {
		return trackingNumbers;
	}
	public void setTrackingNumbers(List<String> trackingNumbers) {
		this.trackingNumbers = trackingNumbers;
	}
	public String getLabelUrl() {
		return labelUrl;
	}
	public void setLabelUrl(String labelUrl) {
		this.labelUrl = labelUrl;
	}
	public String getInvoiceUrl() {
		return invoiceUrl;
	}
	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}
	public String getCarrierTrackingUrl() {
		return carrierTrackingUrl;
	}
	public void setCarrierTrackingUrl(String carrierTrackingUrl) {
		this.carrierTrackingUrl = carrierTrackingUrl;
	}
	public String getPickupConfirmation() {
		return pickupConfirmation;
	}
	public void setPickupConfirmation(String pickupConfirmation) {
		this.pickupConfirmation = pickupConfirmation;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
}
