package entities;


public abstract class cart�o implements Card {

	private Integer code;
	private double value;
	public cart�o( Integer code, double value) {
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
