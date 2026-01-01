
public class LuggageQueue {
	
	protected LinkedNode<Luggage> front;
	protected LinkedNode<Luggage> back;
	private int size;
	
	public LuggageQueue() {
		front = null;
		back = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	public int size() {
		return size;
	}
	
	public void enqueue(Luggage luggage) {
		LinkedNode<Luggage> newLuggage = new LinkedNode<>(luggage);
		if (isEmpty()) {
			front = newLuggage;
		} else {
			back.setNext(newLuggage);
		}
		back = newLuggage;
		size++;
	}
	
	public Luggage dequeue() {
		if (isEmpty()) {
			return null;
		}
		Luggage frontLuggage = front.getData();
		front = front.getNext();
		if (isEmpty()) {
			back = null;
		}
		size--;
		return frontLuggage;
	}
	
	public Luggage peek() {
		if (front == null) {
			return null;
		}
		return front.getData();
	}
	
	public void clear() {
		front = null;
		back = null;
		size = 0;
	}
	
	public boolean contains(Luggage luggage) {
		LinkedNode<Luggage> current = front;
		while (current != null) {
			Luggage currentLuggage = current.getData();
			if (luggage == null && currentLuggage == null) {
				return true;
			} else if (luggage.equals(currentLuggage)) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
	public String getSummary() {
		StringBuilder summary = new StringBuilder("Queue Summary:\n");
		LinkedNode<Luggage> current = front;
		while (current != null) {
			String currentToString = current.toString();
			if (currentToString.endsWith(" -> ")) {
				currentToString = currentToString.substring(0, currentToString.length() - 4);
			}
			summary.append(currentToString);
			if (current.getNext() != null) {
				summary.append("\n");
			}
			current = current.getNext();
		}
		return summary.toString();
	}

}
