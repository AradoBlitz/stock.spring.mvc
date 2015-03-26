package stock.spring.mvc.domain;

public class PriceIncrease {

	private int percentage;
	
	
	
	public int getPercentage() {
		return percentage;
	}



	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof PriceIncrease;
	}

	
}
