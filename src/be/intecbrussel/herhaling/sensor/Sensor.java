package be.intecbrussel.herhaling.sensor;

import java.util.Random;

import be.intecbrussel.herhaling.enums.ConnectionType;
import be.intecbrussel.herhaling.interfaces.Updateable;

public abstract class Sensor implements Updateable{
	private final String ID;
	private static int count = 0;
	private ConnectionType type;
	private String data;
	private Random randy = new Random();
	
	{
		count++;
	}

	/**
	 * Constructor
	 * 
	 * @param id - The id of the sensor
	 */
	public Sensor(String id) {
		this.ID = id;
	}

	/**
	 * @return the sENSOR_ID
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}

	/**
	 * @return the type
	 */
	public ConnectionType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ConnectionType type) {
		this.type = type;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the randy
	 */
	public Random getRandy() {
		return randy;
	}

}
