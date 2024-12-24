# IoT Management System

## Overview
The IoT Management System is a comprehensive solution for managing and monitoring IoT devices. It integrates hardware and software to collect, process, and visualize real-time sensor data. The system uses Spring Boot for the backend, Thymeleaf for the frontend, and Arduino/Raspberry Pi for hardware communication. It tracks environmental data like temperature, humidity, motion detection, and gas levels, presenting it on a user-friendly dashboard.

---

## Features
- **Real-Time Monitoring**: Tracks data from temperature, humidity, motion, and gas sensors.
- **Interactive Dashboard**: Displays sensor data dynamically using Thymeleaf and HTML/CSS.
- **RESTful APIs**: Handles communication between hardware devices and the backend.
- **In-Memory Database**: Uses H2 for efficient, temporary data storage.
- **Scalable Architecture**: Modular design for easy enhancements.

---

## Project Structure

### **Backend (Spring Boot)**
- **Models**: Represents sensor data with entities like `SensorData`.
- **Repositories**: Interfaces for database operations using JPA.
- **Services**: Contains business logic for processing sensor data.
- **Controllers**: Exposes REST APIs and serves web pages.

### **Frontend (Thymeleaf)**
- Interactive dashboard displaying real-time sensor data.
- Templates built using HTML, CSS, and Thymeleaf.

### **Hardware**
- **Arduino Uno**: Collects sensor data (temperature, humidity, motion, and gas levels).
- **Raspberry Pi Zero**: Transmits sensor data to the backend via HTTP.
- **Sensors**:
  - DHT22 (Temperature and Humidity)
  - PIR Motion Sensor
  - MQ-135 Gas Sensor

---

## Prerequisites

### **Software**
- Java 17 or later
- Spring Boot
- Maven
- Arduino IDE
- Python 3 with `pyserial` and `requests` libraries

### **Hardware**
- Raspberry Pi Zero
- Arduino Uno
- Sensors: DHT22, PIR, MQ-135
- Breadboard and jumper wires

---

## Installation

### **Backend Setup**
1. Clone the repository:
    ```bash
    git clone <repository-url>
    cd <repository-folder>
    ```
2. Configure the project using [Spring Initializr](https://start.spring.io/) if necessary.
3. Run the application:
    ```bash
    mvn spring-boot:run
    ```
4. Access the application at `http://localhost:8080`.

### **Arduino Setup**
1. Connect the sensors to the Arduino Uno.
2. Upload the Arduino sketch to collect sensor data:
    ```cpp
    // Code snippet available in the project repository
    ```

### **Raspberry Pi Setup**
1. Install required Python libraries:
    ```bash
    sudo pip3 install pyserial requests
    ```
2. Run the Python script to send data to the backend.
    ```bash
    python3 send_data.py
    ```

---

## Usage
1. Start the Spring Boot application.
2. Power on the Arduino and Raspberry Pi.
3. Navigate to the web dashboard at `http://<laptop-ip>:8080`.
4. Monitor real-time sensor data on the dashboard.

---

## Contributing
Feel free to fork this repository, create a feature branch, and submit a pull request. Contributions are welcome!

---

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## Acknowledgments

- This project was built by Rohit Mishra (GitHub alias: Rex-48).
- Spring Boot for backend framework.
- Arduino and Raspberry Pi communities for hardware support.
- Open source libraries and tools used in this project.

---

