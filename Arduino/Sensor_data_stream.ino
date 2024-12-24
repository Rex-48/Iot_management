#include <DHT.h>

// Pin Definitions
#define DHTPIN 2        // DHT22 sensor pin (Now set to pin 2)
#define DHTTYPE DHT22   // Define DHT sensor type

DHT dht(DHTPIN, DHTTYPE);

// Pin Definitions for other sensors
int pirPin = 3;        // PIR sensor pin (Now set to pin 3)
int gasPin = A0;       // Gas sensor (MQ-135) pin

void setup() {
  // Start serial communication at 9600 baud rate
  Serial.begin(9600);

  // Initialize the DHT sensor
  dht.begin();

  // Set PIR sensor and gas sensor pins
  pinMode(pirPin, INPUT);
  pinMode(gasPin, INPUT);

  // Start message
  Serial.println("Starting sensor tests...");
  delay(2000);  // Wait for a while before starting the readings
}

void loop() {
  // Read temperature and humidity from DHT22
  float temperature = dht.readTemperature();
  float humidity = dht.readHumidity();

  // Read motion status from PIR sensor
  int motion = digitalRead(pirPin);

  // Read gas level (analog value) from MQ-135
  int gasLevel = analogRead(gasPin);

  // Check if any sensor failed (DHT sensor may return NaN if it fails)
  if (isnan(temperature) || isnan(humidity)) {
    Serial.println("Failed to read from DHT sensor!");
  } else {
    // Print sensor readings to the serial monitor
    Serial.print("Temperature: ");
    Serial.print(temperature);
    Serial.print(" °C, ");

    Serial.print("Humidity: ");
    Serial.print(humidity);
    Serial.print(" %, ");
  }

  // Print motion detection status
  if (motion == HIGH) {
    Serial.print("Motion Detected: Yes, ");
  } else {
    Serial.print("Motion Detected: No, ");
  }

  // Print gas sensor reading (analog value)
  Serial.print("Gas Level: ");
  Serial.println(gasLevel);

  // Add a delay before the next loop
  delay(2000); // 2 seconds delay to avoid flooding serial output
}
