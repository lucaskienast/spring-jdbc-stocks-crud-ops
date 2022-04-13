package com.stocks.bean;

public class StockBean {
	
	private String isin;
	private String ticker;
	private String name;
	private float sharePrice;
	private int sharesOutstanding;
	
	public StockBean() {
		super();
	}

	public StockBean(String isin, String ticker, String name, float sharePrice, int sharesOutstanding) {
		super();
		this.isin = isin;
		this.ticker = ticker;
		this.name = name;
		this.sharePrice = sharePrice;
		this.sharesOutstanding = sharesOutstanding;
	}

	public String getIsin() {
		return isin;
	}
	
	public void setIsin(String isin) {
		this.isin = isin;
	}
	
	public String getTicker() {
		return ticker;
	}
	
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getSharePrice() {
		return sharePrice;
	}
	
	public void setSharePrice(float sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	public int getSharesOutstanding() {
		return sharesOutstanding;
	}
	
	public void setSharesOutstanding(int sharesOutstanding) {
		this.sharesOutstanding = sharesOutstanding;
	}

	@Override
	public String toString() {
		return "StockBean [isin=" + isin + ", ticker=" + ticker + ", name=" + name + ", sharePrice=" + sharePrice
				+ ", sharesOutstanding=" + sharesOutstanding + "]";
	}

}
