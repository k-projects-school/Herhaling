package be.intecbrussel.herhaling.devices;

import java.util.Random;

import be.intecbrussel.herhaling.interfaces.Updateable;

public class Light implements Updateable {
	
	private static int count = 0;
	private final String ID;
	private boolean status = false;
	
	{
		count++;
	}
	
	/**
	 * Constructor
	 */
	public Light() {
		this.ID = "Light" + (count);
	}
	
	/**
	 * Turn the light on
	 */
	public void on() {
		this.status = true;
	}
	
	/**
	 * Turn the light of
	 */
	public void off() {
		this.status = false;
	}

	@Override
	public void update() {
		this.off();
		Random rand = new Random();
		if (rand.nextBoolean()) {
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
		return "Light module: \n-ID: " + this.ID + "\n-status: " + (this.status ? "ON" : "OFF");
	}

}
