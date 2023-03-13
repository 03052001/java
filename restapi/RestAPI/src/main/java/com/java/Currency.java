package com.java;

public class Currency {

	
	private int CurrencyId;
	private String sourceCurrency;
	private String targetCurrency;
	private float amountToConvert;
	public int getCurrencyId() {
		return CurrencyId;
	}
	public void setCurrencyId(int currencyId) {
		CurrencyId = currencyId;
	}
	public String getSourceCurrency() {
		return sourceCurrency;
	}
	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}
	public String getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	public float getAmountToConvert() {
		return amountToConvert;
	}
	public void setAmountToConvert(float amountToConvert) {
		this.amountToConvert = amountToConvert;
	}
	
	
	
}
