# 🎮 Command Design Pattern (Java)

![Java](https://img.shields.io/badge/Language-Java-blue.svg)
![Pattern](https://img.shields.io/badge/Design%20Pattern-Behavioral-red.svg)
![Pattern](https://img.shields.io/badge/Pattern-Command-pink)
![Week](https://img.shields.io/badge/Week-8-green)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Intermediate-orange.svg)

---

## 🎥 Lecture Video

This repository accompanies the lecture on the **Command Pattern**, focusing on decoupling requests from execution and transforming actions into reusable objects.

▶️ Watch on YouTube:


[Lecture Video](https://youtu.be/lOnbj1dUJs4)

---

## 🧠 Overview

The **Command Pattern** is a behavioral design pattern that transforms requests/actions into separate objects called:

> Commands

Instead of directly calling methods between objects, the request becomes an independent object that can be:

* executed
* stored
* queued
* logged
* undone
* reused dynamically

This pattern creates loose coupling between:

* the object requesting the action
  and
* the object performing the action

---

## 💡 Core Idea

> Encapsulate a request as an object.

Or more simply:

> Convert actions into objects.

---

## 🏗️ Real-World Analogy

Think about a restaurant system.

There are four important roles:

| Real Life   | Command Pattern |
| ----------- | --------------- |
| Customer    | Client          |
| Waiter      | Invoker         |
| Order Paper | Command         |
| Chef        | Receiver        |

The customer does NOT cook the food directly.

Instead:

1. customer creates an order
2. waiter carries the order
3. chef receives the request
4. chef performs the actual work

The important observation is:

> the order itself represents the request.

This is exactly how the Command Pattern works.

---

## ⚙️ When to Use This Pattern

Use Command Pattern when:

* You need to decouple sender from receiver
* Requests should become reusable objects
* Actions must support undo/redo
* Operations should be queued or scheduled
* Systems require runtime flexibility
* You want to avoid tightly coupled method calls
* Actions need logging/history support

---

## ❌ Problem Without This Pattern

Without Command Pattern, objects directly depend on each other.

Example:

```java id="z3x1vu"
button.turnLightOn();
```

Problems with this approach:

* Tight coupling
* Hard to extend behavior
* Difficult to add new operations
* Undo functionality becomes complex
* UI components become dependent on business logic
* Code becomes harder to maintain

As systems grow, direct method calls create rigid architectures.

---

## 🧩 Solution Approach

The Command Pattern separates responsibilities into four main components.

---

### 🔵 Command Interface

* Defines the common contract
* Usually contains `execute()`
* All commands become interchangeable

---

### 🟢 Concrete Commands

* Represent specific executable actions
* Store receiver objects
* Delegate work to receivers

Examples:

* LightOnCommand
* LightOffCommand
* TVOnCommand
* GarageOpenCommand

---

### 🟣 Receiver

* Performs the actual work
* Contains business logic
* Knows HOW the task is executed

Examples:

* Light
* TV
* Fan
* GarageDoor

---

### 🟡 Invoker

* Triggers command execution
* Does NOT know implementation details
* Depends only on the Command abstraction

Examples:

* RemoteControl
* Button
* MenuItem

---

## 📊 UML Structure

```text
             <<interface>>
                 Command
             ----------------
             + execute()
             + undo()

                    ▲
        ┌───────────┼───────────┐
        │                       │
 LightOnCommand         LightOffCommand

                    │
                    ▼
                  Light
               (Receiver)

                    ▲
                    │
             RemoteControl
                (Invoker)
```

---

## 🧪 Example Scenario — Smart Home System

Imagine a smart home application.

We have devices such as:

* 💡 Lights
* 📺 TVs
* 🌪️ Fans
* 🚪 Garage Doors

We also have a remote control.

### Requirement

The remote should:

* execute multiple operations
* support different devices
* remain independent from device implementations
* allow adding new commands later

Important condition:

> the remote should NOT directly implement device logic.

---

## 🔥 Core Behavior Explained

When the system runs:

* The invoker does NOT know receiver details
* The command object stores the request
* The receiver performs actual work
* The invoker simply calls:

```java id="jlwmgj"
command.execute();
```

This creates:

* loose coupling
* runtime flexibility
* extensibility

---

## 🧠 Key Insight

A very important mental model:

* **Invoker = triggers requests**
* **Command = represents requests**
* **Receiver = performs requests**

Or:

> Invoker decides *when* to execute
> Receiver decides *how* to execute

---

## 🔄 Runtime Flexibility Example

The same remote control can execute completely different actions simply by replacing command objects at runtime.

Example flow:

```text
1. Assign LightOnCommand
2. Press button
3. Assign TVOnCommand
4. Press button
5. Assign GarageOpenCommand
6. Press button
```

No modification is required inside the remote control itself.

---

## 🔁 Undo Support

One of the biggest strengths of the Command Pattern is undo functionality.

Commands can support operations such as:

* execute()
* undo()

This allows systems to reverse previous actions dynamically.

Real-world examples:

* Ctrl + Z
* Photoshop history
* IDE undo systems
* Game action rollback

The key idea:

> each command knows how to reverse itself.

---

## 📚 Real-World Applications

The Command Pattern is widely used in real systems.

Examples include:

* GUI buttons
* menu systems
* task schedulers
* automation systems
* smart home applications
* undo/redo systems
* macro recording
* job queues

---

## 🧠 Design Principles Behind It

This pattern strongly supports:

### ✅ Favor Composition Over Inheritance

Behavior is injected through objects instead of subclassing.

---

### ✅ Open/Closed Principle

New commands can be added without modifying existing classes.

---

### ✅ Single Responsibility Principle

Each command represents one focused action.

---

## 💾 Solutions

📁 [`solutions/`](solutions/)

All solutions are available in the `/solutions` folder.

Each solution includes:

* UML + design explanation
* Clean Java implementation
* Command Pattern usage (runtime command switching)
* Separation between invoker, commands, and receivers
* Notes on design decisions and extensibility
* Example usage via `Main.java`

---

### 🧪 Included Activities

* 🧠 Activity: Smart Office Automation System

> Students should first implement the system independently, then compare their design with the provided solution.

---

## 🎯 Learning Outcome

After studying this pattern, you should be able to:

* Identify tightly coupled request systems
* Separate requester from executor
* Transform actions into reusable objects
* Implement undoable operations
* Build extensible behavioral architectures
* Apply composition correctly

---

# 🚀 Final Insight

The Command Pattern becomes powerful when:

> actions themselves become independent objects that can be executed, stored, queued, reused, and reversed dynamically.
