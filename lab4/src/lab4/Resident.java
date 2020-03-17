package lab4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Resident implements Comparable<Resident> {

	private String name;

	public Resident(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Resident [name=" + name + "]";
	}

	@Override
	public int compareTo(Resident o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
