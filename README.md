# Luggage Transportation System

A Stack and Queue implementation for managing airport luggage handling operations, developed for CS 300 at UW-Madison.

## Project Overview

This project simulates an airport luggage transportation system that efficiently processes luggage from airplane arrival through passenger pickup. The system uses custom Stack and Queue data structures built with linked lists to manage luggage flow through different stages: packing cart, conveyor belt, and lost-and-found.

## System Architecture

The luggage transportation system consists of three main components:

1. **Packing Cart Stack** (LIFO): Stores luggage unloaded from the airplane
2. **Conveyor Belt Queue** (FIFO): Delivers luggage to passengers in order
3. **Lost Luggage Stack** (LIFO): Holds misrouted or unclaimed luggage
```
[Airplane] → [Packing Cart Stack] → [Conveyor Belt Queue] → [Passengers]
                       ↓                      ↓
              [Lost Luggage Stack]  [Lost Luggage Stack]
```

## Features

- **Custom Stack Implementation**: LIFO data structure using singly-linked nodes with O(1) push/pop operations
- **Custom Queue Implementation**: FIFO data structure using singly-linked nodes with O(1) enqueue/dequeue operations
- **Destination Validation**: Automatically routes luggage based on airport codes
- **Duplicate Detection**: Prevents duplicate luggage entries in the packing cart
- **Lost Luggage Handling**: Manages misrouted and unclaimed luggage
- **System Monitoring**: Track delivered luggage and view system status

## Project Structure

### Provided Classes
- `Luggage.java` - Models individual luggage items with owner and destination
- `LinkedNode.java` - Singly-linked node for building data structures
- `QueueADT.java` - Abstract data type interface for queue operations
- `StackADT.java` - Abstract data type interface for stack operations

### Implemented Classes
- `LuggageStack.java` - Custom stack implementation using linked nodes
- `LuggageQueue.java` - Custom queue implementation using linked nodes
- `LuggageTransportationSystem.java` - Main system controller managing luggage flow

## How to Run

### Prerequisites
- Java 8 or higher
- Eclipse IDE (or any Java IDE)

### Running the System

1. Clone this repository:
```
   git clone https://github.com/CadenDay/luggage-transportation-system.git
```

2. Open Eclipse and import the project:
   - File → Open Projects from File System
   - Select the cloned folder

3. Run the main class:
   - Right-click `Main.java`
   - Run As → Java Application

### Example Usage
```java
// Create transportation system for MSN airport
LuggageTransportationSystem system = new LuggageTransportationSystem("MSN");

// Add luggage to packing cart
Luggage bag1 = new Luggage("Alice", "MSN");
Luggage bag2 = new Luggage("Bob", "ORD");
system.addToPackingCart(bag1);
system.addToPackingCart(bag2);

// Transfer luggage to conveyor belt (checks destination)
system.transferToConveyorBelt();  // Alice's bag → conveyor
system.transferToConveyorBelt();  // Bob's bag → lost luggage (wrong airport)

// Deliver luggage to passengers
system.deliverLuggage();  // Alice picks up her bag

// View system status
System.out.println(system.viewConveyorBeltQueue());
System.out.println(system.viewLostLuggageStack());
```

## Implementation Details

### LuggageStack
- **Data Structure**: Singly-linked list with top pointer
- **Operations**: push, pop, peek, clear, contains
- **Complexity**: O(1) for push/pop, O(n) for contains
- **Top Position**: Ensures O(1) add/remove operations

### LuggageQueue
- **Data Structure**: Singly-linked list with front and back pointers
- **Operations**: enqueue, dequeue, peek, clear, contains
- **Complexity**: O(1) for enqueue/dequeue, O(n) for contains
- **Pointer Management**: Maintains both front and back for efficient operations

### Key System Methods

1. **addToPackingCart(Luggage)**: Adds luggage to packing cart if not already present
2. **transferToConveyorBelt()**: Moves luggage from cart to belt or lost-and-found based on destination
3. **deliverLuggage()**: Delivers luggage from belt to matching passenger or to lost-and-found
4. **findLuggageLocation(Luggage)**: Locates luggage within the system

## Learning Outcomes

This project demonstrates:
- Implementation of fundamental data structures (Stack, Queue) from scratch
- Understanding of LIFO and FIFO principles
- Pointer manipulation in linked structures
- Time complexity analysis and optimization
- Application of data structures to real-world problems

## Technical Constraints

- No use of Java's built-in collection classes
- Custom implementation of all data structures
- Only exception class allowed: `java.util.NoSuchElementException`
- Adherence to O(1) time complexity requirements for stack/queue operations

## Course Information

- **Course:** COMP SCI 300 - Programming II
- **Institution:** University of Wisconsin-Madison
- **Semester:** Fall 2025

## Academic Integrity

This project was completed independently following UW-Madison's academic integrity policies. All code was written personally as part of coursework requirements.