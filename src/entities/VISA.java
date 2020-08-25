package entities;

import java.util.ArrayList;
import java.util.List;

public class VISA extends cartão implements Card{

	private static final int tax = 3;
	private static final int antecipationTax = 2;
	
	
	List<Fee> list = new ArrayList<>();

	public VISA(Integer code, double value) {
		super(code, value);
	}
	
	public String getName() {
		return "VISA";
	}
	
	@Override
	public double totalValue() {
		return super.getValue() + super.getValue() *tax/100;
	}
	@Override
	public double totalValueWithAntecipation() {
		return totalValue()+totalValue()*antecipationTax/100; 
	}
	@Override
	public String toString() {
		return "VISA [totalValue()=" + totalValue() + ", totalValueWithAntecipation()=" + totalValueWithAntecipation()
				+ "]";
	}
	
	

	
	

}
