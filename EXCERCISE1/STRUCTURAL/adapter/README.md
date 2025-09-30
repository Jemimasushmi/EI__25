# Adapter Pattern Example

## Overview
This project demonstrates the **Adapter Design Pattern** in Java. The Adapter pattern allows incompatible interfaces to work together. It acts as a bridge between two interfaces that otherwise would not be compatible. In this example, an electric vehicle (EV) can charge using either a new charging socket or an old socket through an adapter.

## Structure
- **NewChargingPort (Interface)**: Defines a `chargeEV()` method that all compatible charging sockets implement.  
- **NewChargingSocket (Concrete Class)**: Implements `NewChargingPort` to provide the new charging functionality.  
- **OldChargingSocket (Legacy Class)**: Provides an old charging method `connectOldPlug()` that is incompatible with the EV.  
- **ChargingAdapter (Adapter Class)**: Implements `NewChargingPort` and adapts the `OldChargingSocket` to the new interface.  
- **EVChargingAdapterDemo (Client Class)**: Takes user input, selects the socket type, and charges the EV using the new interface regardless of the socket type.

## How to Run
1. Ensure you have **Java** installed on your machine.  
2. Save all the code files in a folder named `src`.  
3. Open a terminal/command prompt and navigate to the `src` folder.  
4. Compile the Java files using:
   ```bash
   javac *.java
