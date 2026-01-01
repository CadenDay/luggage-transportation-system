
public class Luggage {
	
	private String owner;
	private String destinationCode;
	
	public Luggage(String owner, String destinationCode) {
		if (owner == null || owner.isBlank()) {
			throw new IllegalArgumentException("Invalid luggage owner");
		}
		if (destinationCode == null || !destinationCode.matches("^[A-Za-z]{3}$")) {
			throw new IllegalArgumentException("Invalid destination code (must be 3 letters)");
		}
		this.owner = owner;
		this.destinationCode = destinationCode.toUpperCase();
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String getDestinationCode() {
		return destinationCode;
	}
	
	@Override
	public String toString() {
		return String.format("Luggage (Owner: %s) -> Destination: %s",
				owner, destinationCode.toUpperCase());
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Luggage) {
			Luggage anotherLuggage = (Luggage) o;
			return this.owner.equals(anotherLuggage.owner) &&
					this.destinationCode.equalsIgnoreCase(anotherLuggage.destinationCode);
		}
		return false;
	}

}
