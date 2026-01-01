
public class LinkedNode<T> {

	private T data;
	private LinkedNode<T> next;
	
	public LinkedNode(T data) {
		this.data = data;
	}
	
	public LinkedNode(T data, LinkedNode<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	
	public LinkedNode<T> getNext() {
		return next;
	}
	
	public void setNext(LinkedNode<T> next) {
		this.next = next;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof LinkedNode<?>) {
			LinkedNode<T> other = (LinkedNode) o;
			return this.equalsHelper(other);
		}
		return false;
	}
	
	protected boolean equalsHelper(LinkedNode<T> other) {
		if (this.next == null) {
			return this.data.equals(other.data) && other.next == null;
		}
		return this.data.equals(other.data) && other.next != null && this.next.equalsHelper(other.next);
	}
	
	@Override
	public String toString() {
		String s = this.data.toString();
		if (this.next != null) {
			s += " -> ";
		}
		return s;
	}
	
}
