import requests
import time
from datetime import datetime

# URL for the server endpoint
url = "http://localhost:8080/data/put"

# Sample data for the tracker
samples = [
    {"deviceId": "tracker01", "latitude": "37.7749", "longitude": "-122.4194", "timestamp": datetime.now().isoformat()},
    {"deviceId": "tracker01", "latitude": "37.7750", "longitude": "-122.4195", "timestamp": datetime.now().isoformat()},
    {"deviceId": "tracker01", "latitude": "37.7751", "longitude": "-122.4196", "timestamp": datetime.now().isoformat()},
    {"deviceId": "tracker01", "latitude": "37.7752", "longitude": "-122.4197", "timestamp": datetime.now().isoformat()},
    {"deviceId": "tracker01", "latitude": "37.7753", "longitude": "-122.4198", "timestamp": datetime.now().isoformat()}
]

for sample in samples:
    params = {
        "deviceId": sample["deviceId"],
        "latitude": sample["latitude"],
        "longitude": sample["longitude"],
        "timestamp": sample["timestamp"]
    }
    
    try:

        response = requests.put(url, params=params)

        print(f"Status Code: {response.status_code}, Response: {response.text}")
    except requests.exceptions.RequestException as e:
        print(f"Error sending data: {e}")
    
    time.sleep(2)
