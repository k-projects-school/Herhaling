package be.intecbrussel.herhaling.enums;

public enum ConnectionType {
	ANALOG, DIGITAL;
	
	/**
	 * Get the first letter of the name
	 * 
	 * @return char - The first letter of the name
	 */
	public char getInitial() {
		return this.name().charAt(0);
	}
}
