package eFindMe.ESGI.client;


public class Reference {
	
	private String source, url, isPositive;	

	
	public Reference(String referenceSource, String url, String positive)
	{
		source =  referenceSource;
		this.url = url;
		isPositive = positive;
	}


	@Override
	public String toString() {
		return this.url;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String value) {
		this.url = value;
	}


	public String getIsPositive() {
		return isPositive;
	}


	public void setIsPositive(String isPositive) {
		this.isPositive = isPositive;
	}
	
	

}
