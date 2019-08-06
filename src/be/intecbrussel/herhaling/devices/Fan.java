package be.intecbrussel.herhaling.devices;

import be.intecbrussel.herhaling.interfaces.Updateable;

public class Fan implements Updateable {

	private static int count = 0;
	private final String ID;
	private boolean status = false;
	
	{
		count++;
	}

	/**
	 * Constructor
	 */
	public Fan() {
		this.ID = "Fan" + (count + 1);
	}

	/**
	 * Turn the fan on
	 */
	public void on() {
		this.status = true;
	}

	/**
	 * Turn the fan of
	 */
	public void off() {
		this.status = false;
	}

	@Override
	public void update() {
		this.off();
		if ((int) Math.random() * ((1 - 0) + 1) + 0 == 1) {
			this.on();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fan module: \n-ID: " + this.ID + "\n-status: " + (this.status ? "ON" : "OFF");
	}
}
