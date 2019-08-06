package be.intecbrussel.herhaling;

import be.intecbrussel.herhaling.sensor.*;

public class Main1 {

	public static void main(String[] args) {
		// Create the sensors
		Sensor[] sensors = new Sensor[6];
		sensors[0] = new WaterSensor();
		sensors[1] = new WaterSensor();
		sensors[2] = new WaterSensor();
		sensors[3] = new TempSensor();
		sensors[4] = new TempSensor();
		sensors[5] = new PushSensor();

		// Loop through the sensors
		for (Sensor sensor : sensors) {
			// Print the sensor if its not a push sensor
			if (!(sensor instanceof PushSensor)) {
				System.out.println(sensor);
			}
		}
		// Print how many sensors there are
		System.out.println("Currently there are " + Sensor.getCount() + " sensors active.");
		System.out.println(WaterSensor.getCounter() + " WaterSensors");
		System.out.println(TempSensor.getCounter() + " TempSensors");
		System.out.println(PushSensor.getCounter() + " PushSensors");
	}

}
