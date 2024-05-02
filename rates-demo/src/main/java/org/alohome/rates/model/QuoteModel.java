package org.alohome.rates.model;

import java.util.List;

public class QuoteModel implements Comparable<QuoteModel> {

	private MoneyAmount baseCharge;
	private List<Surcharge> surcharges;
	private List<Surcharge> taxes;
	private MoneyAmount totalCharge;
	private MoneyAmount totalBeforeTaxes;
	private float exchangeRate;
	private String carrierId;
	private String carrierName;
	private String serviceId;
	private String serviceName;
	private Integer transitDays;
	private Integer transitMaxDays;
	private String cutoffTime;
	private String accessTimeInterval;
	private String serviceTerms;
	private String quoteId;

	@Override
	public int compareTo(QuoteModel o) {
		return totalCharge.getCurrency().equals(o.totalCharge.getCurrency())
				? totalCharge.getAmount().compareTo(o.totalCharge.getAmount())
				: -1;
	}

	public MoneyAmount getBaseCharge() {
		return baseCharge;
	}
	public void setBaseCharge(MoneyAmount baseCharge) {
		this.baseCharge = baseCharge;
	}
	public List<Surcharge> getSurcharges() {
		return surcharges;
	}
	public void setSurcharges(List<Surcharge> surcharges) {
		this.surcharges = surcharges;
	}
	public List<Surcharge> getTaxes() {
		return taxes;
	}
	public void setTaxes(List<Surcharge> taxes) {
		this.taxes = taxes;
	}
	public MoneyAmount getTotalCharge() {
		return totalCharge;
	}
	public void setTotalCharge(MoneyAmount totalCharge) {
		this.totalCharge = totalCharge;
	}
	public MoneyAmount getTotalBeforeTaxes() {
		return totalBeforeTaxes;
	}
	public void setTotalBeforeTaxes(MoneyAmount totalBeforeTaxes) {
		this.totalBeforeTaxes = totalBeforeTaxes;
	}
	public float getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getTransitDays() {
		return transitDays;
	}
	public void setTransitDays(Integer transitDays) {
		this.transitDays = transitDays;
	}
	public Integer getTransitMaxDays() {
		return transitMaxDays;
	}
	public void setTransitMaxDays(Integer transitMaxDays) {
		this.transitMaxDays = transitMaxDays;
	}
	public String getCutoffTime() {
		return cutoffTime;
	}
	public void setCutoffTime(String cutoffTime) {
		this.cutoffTime = cutoffTime;
	}
	public String getAccessTimeInterval() {
		return accessTimeInterval;
	}
	public void setAccessTimeInterval(String accessTimeInterval) {
		this.accessTimeInterval = accessTimeInterval;
	}
	public String getServiceTerms() {
		return serviceTerms;
	}
	public void setServiceTerms(String serviceTerms) {
		this.serviceTerms = serviceTerms;
	}
	public String getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(String quoteId) {
		this.quoteId = quoteId;
	}
}
