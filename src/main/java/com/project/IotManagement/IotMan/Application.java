package com.project.IotManagement.IotMan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class Application {

	// Variables to store the latest sensor data
	private static double temperature = 0;
	private static double humidity = 0;
	private static int gasConcentration = 0;
	private static boolean motionDetected = false;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// REST Controller to handle API requests
	@RestController
	@RequestMapping("/api")
	public static class SensorDataController {

		// Endpoint to receive data from Raspberry Pi
		@PostMapping("/sensor-data")
		public String receiveData(@RequestBody SensorData data) {
			// Update the variables with data sent from Raspberry Pi
			temperature = data.getTemperature();
			humidity = data.getHumidity();
			gasConcentration = data.getGasConcentration();
			motionDetected = data.isMotionDetected();

			System.out.println("Received Data: " + data); // Log the received data
			return "Data received successfully";
		}

		// Endpoint to send the latest sensor data to the frontend
		@GetMapping("/sensor-data")
		public SensorData getData() {
			return new SensorData(temperature, humidity, gasConcentration, motionDetected);
		}
	}

	// Data model for sensor readings
	public static class SensorData {
		private double temperature;
		private double humidity;
		private int gasConcentration;
		private boolean motionDetected;

		// Default constructor for JSON deserialization
		public SensorData() {}

		// Constructor to initialize sensor data
		public SensorData(double temperature, double humidity, int gasConcentration, boolean motionDetected) {
			this.temperature = temperature;
			this.humidity = humidity;
			this.gasConcentration = gasConcentration;
			this.motionDetected = motionDetected;
		}

		// Getters and Setters
		public double getTemperature() { return temperature; }
		public void setTemperature(double temperature) { this.temperature = temperature; }
		public double getHumidity() { return humidity; }
		public void setHumidity(double humidity) { this.humidity = humidity; }
		public int getGasConcentration() { return gasConcentration; }
		public void setGasConcentration(int gasConcentration) { this.gasConcentration = gasConcentration; }
		public boolean isMotionDetected() { return motionDetected; }
		public void setMotionDetected(boolean motionDetected) { this.motionDetected = motionDetected; }

		@Override
		public String toString() {
			return "SensorData{" +
					"temperature=" + temperature +
					", humidity=" + humidity +
					", gasConcentration=" + gasConcentration +
					", motionDetected=" + motionDetected +
					'}';
		}
	}

	// Controller to serve the dashboard HTML
	@RestController
	public static class WebController {
		@GetMapping("/")
		public ModelAndView index() {
			return new ModelAndView("index"); // Serves the 'index.html' from templates
		}
	}
}
