package eFindMe.ESGI.client;


public class Reference {
	
	private String source, value, isPositive;	

	
	public Reference(String referenceSource, String url, String positive)
	{
		source =  referenceSource;
		value = url;
		isPositive = positive;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getIsPositive() {
		return isPositive;
	}


	public void setIsPositive(String isPositive) {
		this.isPositive = isPositive;
	}
	
	

}
