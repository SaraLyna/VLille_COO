package projetCOO.util;

public class Pair<T, U> {

	private T first;
	private U second;
	
	/**
	 * constructor class that constructs a Pair of two element 
	 * 
	 */
	public Pair(T f, U s) {
		this.first = f;
		this.second = s;
	}
	
	/**
	 * gives the first element of this Pair
	 * @return T
	 */
	public T getFirst() {
		return this.first;
	}
	
	/**
	 * sets the first element of this Pair
	 * @param f
	 */
	public void setFirst(T f) {
		this.first = f;
	}
	
	/**
	 * gives the second element of this Pair
	 * @return U
	 */
	public U getSecond() {
		return this.second;
	}
	
	/**
	 * sets the second element of this Pair
	 * @param s
	 */
	public void setSecond(U s) {
		this.second = s;
	}
	
	/**
	 * display the Pair
	 */
	public String toString() {
		return "( " + this.first + ", " + this.second + " )";
	}

}
