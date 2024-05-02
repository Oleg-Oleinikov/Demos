package org.alohome.rates.model;

public class CreateShipmentRequest {

	private RatesRequest rateRequest;
	private String carrierId;
	private String serviceId;
	private String quoteId;
	private PickupDetail pickupDetail = new PickupDetail();

	public RatesRequest getRateRequest() {
		return rateRequest;
	}
	public CreateShipmentRequest setRateRequest(RatesRequest rateRequest) {
		this.rateRequest = rateRequest;
		return this;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public CreateShipmentRequest setCarrierId(String carrierId) {
		this.carrierId = carrierId;
		return this;
	}
	public String getServiceId() {
		return serviceId;
	}
	public CreateShipmentRequest setServiceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}
	public String getQuoteId() {
		return quoteId;
	}
	public CreateShipmentRequest setQuoteId(String quoteId) {
		this.quoteId = quoteId;
		return this;
	}
	public PickupDetail getPickupDetail() {
		return pickupDetail;
	}
	public CreateShipmentRequest setPickupDetail(PickupDetail pickupDetail) {
		this.pickupDetail = pickupDetail;
		return this;
	}
}
