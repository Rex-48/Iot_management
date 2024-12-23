package com.project.IotManagement.IotMan;

public class TestData {
    private String message;  // Example: "Hello from Raspberry Pi"

    // Getter and Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "message='" + message + '\'' +
                '}';
    }
}
