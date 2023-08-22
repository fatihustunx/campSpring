package kodlama.io.rentACar.entities.conceretes.enums;

public enum State {

	AVAILIBLE("availible"), MAINTINENCE("maintinence") ,RENTED("rented");
	
	private String state;
	
	State(String state) {
		this.state=state;
	}
	
	public String toString() {
		return state;
	}
}

//1-Available, 2-Rented, 3-Maintenance..