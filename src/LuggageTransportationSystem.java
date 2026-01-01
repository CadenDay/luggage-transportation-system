import java.util.NoSuchElementException;

public class LuggageTransportationSystem {

	private LuggageStack packingCartStack;
	private LuggageStack lostLuggageStack;
	private LuggageQueue conveyorBeltQueue;
	private String airportCode;
	private String[] passengers;
	private int luggageDelivered;
	
	public LuggageTransportationSystem(String airportCode, String[] passengers) {
		packingCartStack = new LuggageStack();
		lostLuggageStack = new LuggageStack();
		conveyorBeltQueue = new LuggageQueue();
		if (airportCode == null) {
			throw new IllegalArgumentException("airportCode cannot be empty");
		}
		for (char letter : airportCode.toCharArray()) {
			if (letter < 'A' || letter > 'Z') {
				throw new IllegalArgumentException("invalid character found");
			}
		}
		if (airportCode.length() != 3) {
			throw new IllegalArgumentException("airportCode must be exactly 3 letters");
		}
		if (passengers == null || passengers.length == 0) {
			throw new IllegalArgumentException("passengers cannot be null or empty");
		}
		for (String name : passengers) {
			if (name == null || name.isBlank()) {
				throw new IllegalArgumentException("passenger names cannot be null or blank");
			}
		}
		this.airportCode = airportCode;
		this.passengers = passengers;
	}
	
	public int getLuggageDelivered() {
		return luggageDelivered;
	}
	
	public String viewPackingCartStack() {
		return packingCartStack.getSummary();
	}
	
	public String viewConveyorBeltQueue() {
		return conveyorBeltQueue.getSummary();
	}
	
	public String viewLostLuggageStack() {
		return lostLuggageStack.getSummary();
	}
	
	public boolean addToPackingCart(Luggage luggage) {
		if (packingCartStack.contains(luggage)) {
			return false;
		} else {
			packingCartStack.push(luggage);
			return true;
		}
	}
	
	public void transferToConveyorBelt() {
		if (packingCartStack.isEmpty()) {
			throw new NoSuchElementException("packingCartStack is currently empty");
		}
		Luggage removedLuggage = packingCartStack.pop();
		String location = removedLuggage.getDestinationCode();
		if (location != null && location.equals(airportCode)) {
			conveyorBeltQueue.enqueue(removedLuggage);
		} else {
			lostLuggageStack.push(removedLuggage);
		}
	}
	
	public boolean deliverLuggage() {
		if (conveyorBeltQueue.isEmpty()) {
			throw new NoSuchElementException("conveyorBeltQueue is currently empty");
		}
		Luggage deliveredLuggage = conveyorBeltQueue.dequeue();
		String luggageName = deliveredLuggage.getOwner();
		for (String passenger : passengers) {
			if (luggageName.equals(passenger)) {
				luggageDelivered++;
				return true;
			}
		}
		lostLuggageStack.push(deliveredLuggage);
		return false;
	}
	
	public Luggage viewNextToTransfer() {
		if (packingCartStack.isEmpty()) {
			throw new NoSuchElementException("packingCartStack is empty");
		}
		return packingCartStack.peek();
	}
	
	public Luggage viewNextToDeliver() {
		if (conveyorBeltQueue.isEmpty()) {
			throw new NoSuchElementException("conveyorBeltQueue is empty");
		}
		return conveyorBeltQueue.peek();
	}
	
	public String findLuggageLocation(Luggage luggage) {
		if (packingCartStack.contains(luggage)) {
			return "Found in packing Cart";
		} else if (conveyorBeltQueue.contains(luggage)) {
			return "Found on Conveyor Belt";
		} else if (lostLuggageStack.contains(luggage)) {
			return "Found in Lost Luggage";
		}
		return "Luggage Not Found";
	}
	
}
