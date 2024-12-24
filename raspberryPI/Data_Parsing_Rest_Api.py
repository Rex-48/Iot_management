from flask import Flask, jsonify, request
import random

app = Flask(__name__)

# Simulated sensor data
sensor_data = {
    "temperature": 25.0,  # Default temperature in Celsius
    "humidity": 50.0,     # Default humidity in %
    "gas_concentration": 150,  # Default gas concentration in ppm
    "motion_detected": False   # Default motion detection state
}

@app.route('/api/sensor-data', methods=['GET'])
def get_sensor_data():
    """
    Endpoint to get the current sensor data.
    Returns a JSON object with temperature, humidity, gas concentration, and motion status.
    """
    return jsonify(sensor_data)

@app.route('/api/sensor-data', methods=['POST'])
def update_sensor_data():
    """
    Endpoint to update the sensor data.
    Expects JSON with keys: temperature, humidity, gas_concentration, motion_detected.
    """
    global sensor_data
    try:
        data = request.get_json()
        sensor_data['temperature'] = data.get('temperature', sensor_data['temperature'])
        sensor_data['humidity'] = data.get('humidity', sensor_data['humidity'])
        sensor_data['gas_concentration'] = data.get('gas_concentration', sensor_data['gas_concentration'])
        sensor_data['motion_detected'] = data.get('motion_detected', sensor_data['motion_detected'])
        return jsonify({"message": "Sensor data updated successfully"}), 200
    except Exception as e:
        return jsonify({"error": str(e)}), 400

@app.route('/api/test', methods=['GET'])
def test_api():
    """
    Endpoint to check if the API is running correctly.
    """
    return jsonify({"message": "API is working!"}), 200

# Utility function to simulate live data updates (optional for testing purposes)
@app.route('/api/simulate', methods=['POST'])
def simulate_sensor_data():
    """
    Simulates sensor data for testing.
    """
    global sensor_data
    sensor_data['temperature'] = round(random.uniform(20.0, 30.0), 2)
    sensor_data['humidity'] = round(random.uniform(40.0, 60.0), 2)
    sensor_data['gas_concentration'] = random.randint(100, 300)
    sensor_data['motion_detected'] = bool(random.getrandbits(1))
    return jsonify({"message": "Simulated data updated successfully"}), 200

if __name__ == '__main__':
    # Run the Flask app
    app.run(host='0.0.0.0', port=5000, debug=True)
