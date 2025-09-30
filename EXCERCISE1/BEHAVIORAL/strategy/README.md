# Strategy Pattern Example

## Overview
This project demonstrates the **Strategy Design Pattern** in Java. The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. It allows the algorithm to vary independently from the clients that use it. In this example, an image editor can apply different filters (Grayscale or Sepia) to an image using interchangeable strategies.

## Structure
- **FilterStrategy (Interface)**: Defines the `applyFilter()` method that all concrete filters implement.  
- **GrayscaleFilter (Concrete Strategy)**: Implements `FilterStrategy` to apply a grayscale filter.  
- **SepiaFilter (Concrete Strategy)**: Implements `FilterStrategy` to apply a sepia filter.  
- **ImageEditor (Context Class)**: Maintains a reference to a `FilterStrategy` and applies it.  
- **StrategyDemo (Client Class)**: Provides a menu for the user to select and apply filters to the image.

## How to Run
1. Ensure you have **Java** installed on your machine.  
2. Save all the code files in a folder named `src`.  
3. Open a terminal/command prompt and navigate to the `src` folder.  
4. Compile the Java files using:
   ```bash
   javac *.java
