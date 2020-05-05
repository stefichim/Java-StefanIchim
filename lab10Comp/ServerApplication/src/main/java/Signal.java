
public class Signal {

	boolean value=false;

	public synchronized boolean isValue() {
		return value;
	}

	public synchronized void setValue(boolean value) {
		this.value = value;
	}
	
}
