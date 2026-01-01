
public class LuggageStack {
	
	protected LinkedNode<Luggage> top;
	private int size;
	
	public LuggageStack() {
		top = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int size() {
		return size;
	}
	
	public void push(Luggage luggage) {
		LinkedNode<Luggage> newLuggage = new LinkedNode<>(luggage);
		newLuggage.setNext(top);
		top = newLuggage;
		size++;
	}
	
	public Luggage pop() {
		if (isEmpty()) {
			return null;
		}
		Luggage topLuggage = top.getData();
		top = top.getNext();
		size--;
		return topLuggage;
	}
	
	public Luggage peek() {
		if (top == null) {
			return null;
		}
		return top.getData();
	}
	
	public void clear() {
		top = null;
		size = 0;
	}
	
	public boolean contains(Luggage luggage) {
		LinkedNode<Luggage> current = top;
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
		StringBuilder summary = new StringBuilder("Stack Summary:\n");
		LinkedNode<Luggage> current = top;
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
