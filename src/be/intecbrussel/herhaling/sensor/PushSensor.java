package be.intecbrussel.herhaling.sensor;

import be.intecbrussel.herhaling.enums.ConnectionType;

public class PushSensor extends Sensor {
	private static int counter = 0;

	private boolean pushed = false;

	{
		counter++;
	}

	/**
	 * Constructor
	 */
	public PushSensor() {
		super(ConnectionType.ANALOG.getInitial() + "push" + counter);
	}

	/**
	 * Push the sensor
	 */
	public void doPush() {
		this.setPushed(true);
	}

	/**
	 * @return the pushed
	 */
	public boolean isPushed() {
		return pushed;
	}

	/**
	 * Get the counter
	 * 
	 * @return the counter
	 */
	public static int getCounter() {
		return counter;
	}

	/**
	 * @param pushed the pushed to set
	 */
	public void setPushed(boolean pushed) {
		this.pushed = pushed;
	}

	@Override
	public void update() {
		this.doPush();
	}
}
