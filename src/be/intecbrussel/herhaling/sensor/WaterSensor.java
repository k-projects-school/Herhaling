package be.intecbrussel.herhaling.sensor;

import be.intecbrussel.herhaling.enums.ConnectionType;
import be.intecbrussel.herhaling.exceptions.SensorOutOfRangeException;

public class WaterSensor extends Sensor {
	private int address;
	private final double MIN_VALUE, MAX_VALUE;
	private float value;
	private static int counter = 0;

	{
		counter++;
	}

	/**
	 * Constructor
	 */
	public WaterSensor() {
		this(ConnectionType.ANALOG, 0, 100);
	}

	/**
	 * Constructor
	 * 
	 * @param type   - The connection type
	 * @param minVal - The minimum value of the sensor
	 * @param maxVal - The maximum value of the sensor
	 */
	public WaterSensor(ConnectionType type, double minVal, double maxVal) {
		super(type.getInitial() + "water" + (counter + 1));
		this.MIN_VALUE = minVal;
		this.MAX_VALUE = maxVal;
		this.setRandomAddress();
		this.setRandomValue();
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return Integer.toHexString(address);
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(int address) {
		this.address = address;
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
	 * @return the current value
	 */
	public double getValue() {
		try {
			if (this.value > this.MAX_VALUE) {
				throw new SensorOutOfRangeException("Het water van sensor \"" + this.getID() + "\" is te heet");
			}
			if (this.value < MIN_VALUE) {
				throw new SensorOutOfRangeException("Het water \"" + this.getID() + "\" is te koud");
			}
		} catch (SensorOutOfRangeException e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(float value) {
		this.value = value;
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
	 * Set a random address
	 */
	private void setRandomAddress() {
		int val = this.getRandy().nextInt(75);
		String hex = Integer.toHexString(val);
		this.address = Integer.parseInt(hex, 16);
	}

	/**
	 * Set a random value
	 */
	private void setRandomValue() {
		this.value = (float) (this.getRandy().nextFloat() * (MAX_VALUE - MIN_VALUE) - MIN_VALUE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Watersensor: \n-Sensor ID: " + this.getID() + "\n-Minimum value: " + MIN_VALUE + "\n-Maximum value: "
				+ MAX_VALUE + "\n-Current value: " + this.getValue() + "\n-Address = " + address;
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
	public void doWaterUpdate() {
		this.setRandomValue();
		if (this.getRandy().nextBoolean()) {
			this.overHeat();
		}
	}

	@Override
	public void update() {
		this.doWaterUpdate();
	}
}
