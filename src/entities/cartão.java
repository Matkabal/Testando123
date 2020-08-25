package entities;


public abstract class cartão implements Card {

	private Integer code;
	private double value;
	public cartão( Integer code, double value) {
		this.code = code;
		this.value = value;
	}

	public abstract String getName();
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
}
