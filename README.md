# Live Tracking System

## Project Overview

The Live Tracking System is a comprehensive solution built using **Spring Boot**, **Angular**, and **MySQL** to track devices in real-time. The system allows users to view past device locations and track devices live as they move, utilizing data sent by a tracking device to the backend server. The backend, powered by **Spring Boot**, receives and processes location data, while the frontend built with **Angular** provides a user interface for live and past tracking views.

### Key Features:
- **Live Tracking**: Track devices in real-time based on data received from GPS tracking devices.
- **Past Data Viewing**: Retrieve and view past location data for devices based on specified time intervals.
- **Device Management**: Add users and authenticate them for secure access to the system.
- **Real-time Location Update**: Device location updates are sent from a Python-based tracking system and stored in a MySQL database.

## Technologies Used:
- **Backend**: Spring Boot, Java
- **Frontend**: Angular
- **Database**: MySQL
- **Tracking Device Integration**: Python
- **API Communication**: RESTful API
- **Data Storage**: MySQL for storing device locations and user data

## Prerequisites

- **Java** 8 or above
- **Spring Boot** framework
- **Angular** for frontend
- **MySQL** for database
- **Python** (for sending tracking data to the server)
- **Git** (if you're using GitHub to push your project)

## Setup Instructions

### 1. Clone the repository

Clone the repository to your local machine using GitHub Desktop or the following Git command:

```bash
git clone https://github.com/yourusername/live-tracking-system.git
2. Setting up the Backend
Install Java and Maven if you haven't already.

Navigate to the backend project folder.

Configure MySQL Database:

Create a new MySQL database and user for the project.
Update the application.properties or application.yml file in the src/main/resources folder to include your database credentials.
Run the backend Spring Boot application:

bash
Copy code
mvn spring-boot:run
The backend API will now be running locally on port 8080.

3. Setting up the Frontend
Install Node.js and Angular CLI if you haven’t already:

bash
Copy code
npm install -g @angular/cli
Navigate to the frontend project folder and install dependencies:

bash
Copy code
cd frontend
npm install
Run the Angular development server:

bash
Copy code
ng serve
The frontend will be available at http://localhost:4200.
Python Script for Sending Data
To simulate the tracking device, you can use a Python script that sends location data to the backend. Here's a simple example of how to do this:

python
Copy code
import requests
import time

url = 'http://localhost:8080/data/put'

data = {
    'deviceId': 'device_123',
    'latitude': '28.7041',
    'longitude': '77.1025',
    'timestamp': '2024-11-10T12:30:00'
}

while True:
    response = requests.put(url, params=data)
    print(f"Data sent: {data}")
    time.sleep(5)  # Sends data every 5 seconds
Run this script to start sending GPS data to the backend.

5. Testing the System
Login: Use the /user/login API endpoint to authenticate users.
Send Tracking Data: Use the /data/put endpoint to send device location data to the backend.
Live Tracking: Use the /live/track endpoint to view live tracking data for devices.
View Past Data: Use the /data/get endpoint to fetch location data from a given time range.
6. API Endpoints
User Endpoints
Login: POST /user/login

Request body: { "username": "email", "password": "password" }
Response: Login success or failure message.
Add User: PUT /user/new

Request body: { "email": "user@example.com", "password": "password" }
Response: Success or failure message.
Tracking Endpoints
Send Device Data: PUT /data/put

Parameters: deviceId, latitude, longitude, timestamp
Description: Receives location data for devices.
Get Past Device Data: GET /data/get

Parameters: deviceId, startTime, endTime
Description: Retrieve location data for a specific device within a time range.
Live Tracking: GET /live/track

Parameters: device, timestamp
Description: View live tracking data for a device.
Contributing
If you'd like to contribute to the project, feel free to fork the repository, make your changes, and submit a pull request. Ensure that your code follows the existing structure and is thoroughly tested.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgements
Special thanks to GitHub for hosting this project.
MySQL for data storage.
Spring Boot and Angular for creating the framework for this system.
Python for simulating the tracking device.
markdown


---

### Notes:
1. **Replace placeholder URLs** (`https://github.com/yourusername/live-tracking-system.git`) with your actual GitHub repository URL.
2. The **Python script** for sending data to the server is a simple example. You can modify it according to your actual device data format.
3. Add any additional **dependencies** or **setup steps** based on your project's actual requirements.

This **README.md** will help other users and developers understand your project, how to set it up, and how to use it. You can upload it along with the rest of your code to your GitHub repository.

