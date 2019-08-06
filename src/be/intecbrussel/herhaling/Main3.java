package be.intecbrussel.herhaling;

import be.intecbrussel.herhaling.devices.Light;

public class Main3 {

	public static void main(String[] args) {
		// Create a new light
		Light light = new Light();
		// Turn the light on
		light.on();
		// Print the data
		System.out.println(light);

		// Change the status of the light
		light.update();
		// Print the light again
		System.out.println(light);
	}

}
