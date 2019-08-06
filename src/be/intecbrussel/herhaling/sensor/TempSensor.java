package be.intecbrussel.herhaling.sensor;

import be.intecbrussel.herhaling.enums.ConnectionType;

public class TempSensor extends Sensor {
	private float value;
	private final double MIN_VALUE, MAX_VALUE;
	private boolean celcius;
	private static int counter = 0;

	{
		counter++;
	}

	/**
	 * Constructor
	 */
	public TempSensor() {
		this(ConnectionType.ANALOG, -45, 200);
	}

	/**
	 * Constructor
	 * 
	 * @param type   - The connection type
	 * @param minVal - The minimum value of the sensor
	 * @param maxVal - The maximum value of the sensor
	 */
	public TempSensor(ConnectionType type, double minVal, double maxVal) {
		super(type.getInitial() + "temp" + (counter + 1));
		this.MIN_VALUE = minVal;
		this.MAX_VALUE = maxVal;
		this.setRandomValue();
	}

	/**
	 * @return the value
	 */
	public float getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(float value) {
		this.value = value;
	}

	/**
	 * @return the celcius
	 */
	public boolean isCelcius() {
		return celcius;
	}

	/**
	 * @param celcius the celcius to set
	 */
	public void setCelcius(boolean celcius) {
		this.celcius = celcius;
	}

	/**
	 * @return the minimum value
	 */
	public double getMinValue() {
		return MIN_VALUE;
	}

	/**
	 * @return the maximum value
	 */
	public double getMaxValue() {
		return MAX_VALUE;
	}
	
	/**
	 * Get the counter
	 * 
	 * @return The counter
	 */
	public static int getCounter() {
		return counter;
	}

	/**
	 * Set a random value
	 */
	private void setRandomValue() {
		this.value = (float) ((float) this.getRandy().nextFloat() * (MAX_VALUE - MIN_VALUE) - MIN_VALUE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TempSensor: \n-Sensor ID: " + this.getID() + "\n-Minimum value: " + MIN_VALUE
				+ "\n-Maximum value: " + MAX_VALUE + "\n-Current value: " + this.getValue() + "\n-Temp in F/C: " + (this.celcius ? "C" : "F");
	}

	/**
	 * Get a random value that goes to hot
	 */
	public void overHeat() {
		this.setValue((float) (this.getRandy().nextFloat() + MAX_VALUE));
	}

	/**
	 * Update the value of the sensor
	 */
	public void doTempUpdate() {
		this.setRandomValue();
		if (this.getRandy().nextBoolean()) {
			this.overHeat();
		}
	}

	@Override
	public void update() {
		this.doTempUpdate();
	}
}
