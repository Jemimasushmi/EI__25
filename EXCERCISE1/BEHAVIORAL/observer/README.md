# Observer Pattern Example

## Overview
This project demonstrates the **Observer Design Pattern** in Java. The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified automatically. In this example, a weather station notifies multiple displays (phone and billboard) whenever the temperature changes.

## Structure
- **Observer (Interface)**: Defines the `update(float temperature)` method that all concrete observers implement.  
- **WeatherStation (Subject Class)**: Maintains a list of observers and notifies them whenever the temperature changes.  
- **PhoneDisplay (Concrete Observer)**: Implements `Observer` to display temperature on a phone.  
- **BillboardDisplay (Concrete Observer)**: Implements `Observer` to display temperature on a billboard.  
- **ObserverDemo (Client Class)**: Provides a menu to attach/detach observers and set the temperature.

## How to Run
1. Ensure you have **Java** installed on your machine.  
2. Save all the code files in a folder named `src`.  
3. Open a terminal/command prompt and navigate to the `src` folder.  
4. Compile the Java files using:
   ```bash
   javac *.java
