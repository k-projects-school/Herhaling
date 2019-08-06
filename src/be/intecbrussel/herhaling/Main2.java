package be.intecbrussel.herhaling;

import be.intecbrussel.herhaling.sensor.WaterSensor;

public class Main2 {

	public static void main(String[] args) {
		// Create a water sensor
		WaterSensor sensor = new WaterSensor();
		int count = 0;
		do {
			// Over heat the sensor
			sensor.overHeat();
			// Print the sensor
			System.out.println(sensor);
			System.out.println("------------------------------------------------");
			count++;
		} while (count < 10);
	}

}
