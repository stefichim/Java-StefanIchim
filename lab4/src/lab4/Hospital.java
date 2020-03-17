package lab4;

public class Hospital implements Comparable<Hospital> {
	
	private double capacity;
	private String name;
	
	public Hospital(double capacity, String name) {
		super();
		this.capacity = capacity;
		this.name = name;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Hospital arg0) {
		return this.getName().compareTo(arg0.getName());//obiectul pe care il compara??
		// TODO Auto-generated method stub
	}

	@Override
	public String toString() {
		return "Hospital [capacity=" + capacity + ", name=" + name + "]";
	}
	
	
	
	
}
