package entities;

public class MasterCard extends cartão implements Card {
	
	private static final int tax = 5;
	private static final int antecipationTax = 4;
	
	


	public MasterCard(Integer code, double value) {
		super( code, value);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return "MasterCard";
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
		return "MasterCard [totalValue()=" + totalValue() + ", totalValueWithAntecipation()=" + totalValueWithAntecipation()
				+ "]";
	}
}
