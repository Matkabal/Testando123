package entities;

public class Leitor {
	
	private String name;
	private double total;
	private double total2;
	public Leitor(String name, double total, double total2) {
		this.name = name;
		this.total = total;
		this.total2 = total2;
	}
	public String getName() {
		return name;
	}
	public double getTotal() {
		return total;
	}
	public double getTotal2() {
		return total2;
	}
	@Override
	public String toString() {
		return  name + ", total value=" + total + ", total value with antecipation=" + total2 + "]";
	}
	
	
	
	
	

}
