package entities;

public class Fee {
	
	private Double values;
	private Integer tax;
	
	public Fee() {
		
	}

	public Fee(Double values, Integer tax) {
		this.values = values;
		this.tax = tax;
	}

	public Double getValues() {
		return values;
	}

	public void setValues(Double values) {
		this.values = values;
	}

	public Integer getTax() {
		return tax;
	}

	public void setTax(Integer tax) {
		this.tax = tax;
	}
	
	public Double totalValue() {
		return values + values * tax/100;
	}
	@Override
	public String toString() {
		return "Value is " +String.format("%.2f", totalValue());
	}
	

}
