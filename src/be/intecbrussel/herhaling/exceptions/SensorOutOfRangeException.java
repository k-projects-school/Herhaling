package be.intecbrussel.herhaling.exceptions;

public class SensorOutOfRangeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param message - The message to set
	 */
	public SensorOutOfRangeException(String message) {
		super(message);
	}

}
