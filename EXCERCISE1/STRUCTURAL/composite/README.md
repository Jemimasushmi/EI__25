# Composite Pattern Example

## Overview
This project demonstrates the **Composite Design Pattern** in Java. The Composite pattern allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly. In this example, a course module contains multiple lessons, and both are treated as `Content`.

## Structure
- **Content (Interface)**: Defines the `show()` method that both lessons and modules implement.  
- **Lesson (Leaf Class)**: Implements `Content` to represent individual lessons.  
- **Module (Composite Class)**: Implements `Content` and can contain multiple `Content` objects (lessons or other modules). Provides an `add()` method to add content.  
- **compositeDemo (Client Class)**: Takes user input to create a module, add lessons to it, and display the full course content.

## How to Run
1. Ensure you have **Java** installed on your machine.  
2. Save all the code files in a folder named `src`.  
3. Open a terminal/command prompt and navigate to the `src` folder.  
4. Compile the Java files using:
   ```bash
   javac *.java
