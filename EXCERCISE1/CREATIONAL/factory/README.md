# Factory Pattern Example

## Overview
This project demonstrates the **Factory Design Pattern** in Java. The pattern provides a way to create objects without exposing the instantiation logic to the client and refers to the newly created object using a common interface. In this example, a notification system supports sending either Email or SMS notifications based on user input.

## Structure
- **Notification (Interface)**: Defines a `notifyUser()` method that all concrete notifications implement.  
- **EmailNotification (Concrete Class)**: Implements `Notification` to send email notifications.  
- **SMSNotification (Concrete Class)**: Implements `Notification` to send SMS notifications.  
- **NotificationFactory (Factory Class)**: Creates instances of `Notification` based on input.  
- **FactoryDemo (Client Class)**: Takes user input, calls the factory to get the appropriate notification, and executes it.  

## How to Run
1. Ensure you have **Java** installed on your machine.  
2. Save all the code files in a folder named `src`.  
3. Open a terminal/command prompt and navigate to the `src` folder.  
4. Compile the Java files using:
   ```bash
   javac *.java
