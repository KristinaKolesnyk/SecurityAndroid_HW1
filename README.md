# Android Login App

This Android application demonstrates a simple login mechanism that validates the user based on specific conditions: battery percentage, Wi-Fi, and Bluetooth status. Below is a detailed explanation of the application code and its functionality.

## Overview

The application contains a single activity (`MainActivity`) which presents a user interface for login. The user must enter a password that matches the current battery percentage of the device, and ensure both Wi-Fi and Bluetooth are enabled to successfully log in.

## Features

- User login validation
- Checks battery percentage
- Checks Wi-Fi status
- Checks Bluetooth status

## How to Use

1. Clone the repository and open it in Android Studio.
2. Build and run the application on an Android device or emulator.
3. Enter any username.
4. Enter the current battery percentage of the device as the password.
5. Ensure both Wi-Fi and Bluetooth are enabled.
6. Click the login button.
7. If the login is successful, the app navigates to the next activity (`NextActivity`).

## Dependencies

- AndroidX Libraries
- Google Material Components
