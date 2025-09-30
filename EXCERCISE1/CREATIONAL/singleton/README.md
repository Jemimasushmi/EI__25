# Singleton Pattern Example

## Overview
This project demonstrates the **Singleton Design Pattern** in Java. The Singleton pattern ensures that a class has only one instance and provides a global point of access to it. In this example, a `Leaderboard` maintains scores for players, and only a single instance of the leaderboard exists throughout the program.

## Structure
- **Leaderboard (Singleton Class)**:  
  - Private constructor to prevent multiple instances.  
  - Static method `getInstance()` to provide global access to the single instance.  
  - Methods to update player scores and display the leaderboard.  
- **SingletonDemo (Client Class)**:  
  - Uses the singleton instance to update scores for multiple players and display the leaderboard.

## How to Run
1. Ensure you have **Java** installed on your machine.  
2. Save all the code files in a folder named `src`.  
3. Open a terminal/command prompt and navigate to the `src` folder.  
4. Compile the Java files using:
   ```bash
   javac *.java
