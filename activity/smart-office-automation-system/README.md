# 🧪 Activity: Smart Office Automation System (Command Pattern)

## 🎯 Objective

Design a system using the **Command Pattern** to control multiple smart office devices while supporting **runtime flexibility and loose coupling**.

---

## 📌 Scenario

You are building a **Smart Office Automation System**.

The office contains multiple smart devices such as:

* 💡 Lights
* 📽️ Projector
* ❄️ Air Conditioner (AC)
* ☕ Coffee Machine

The office control panel should be able to:

* trigger commands dynamically
* work with different devices
* remain independent from device implementation details

Important requirement:

> the control panel should NOT directly control device logic.

---

## ⚠️ Problem Context

Without a proper design:

* The control panel becomes tightly coupled to devices
* Device logic may be hardcoded inside one class
* Adding new devices requires modifying existing code
* Large conditional statements may appear
* Undo functionality becomes difficult
* System flexibility decreases over time

---

## 🧠 Your Task

* Design a **Smart Office Automation System** using the **Command Pattern**
* Encapsulate each device action into its own command class
* Create an invoker that executes commands dynamically
* Ensure the control panel depends only on abstractions
* Support runtime command swapping

---

## 📏 Requirements

Your system must include:

---

### 🔵 Command Interface

A common interface containing:

* `execute()`

Optional extension:

* `undo()`

---

### 🟢 Concrete Commands

Create command classes for different operations such as:

* LightOnCommand
* LightOffCommand
* ProjectorStartCommand
* ACStartCommand
* CoffeeMachineStartCommand

Each command should:

* implement the Command interface
* contain a receiver object
* delegate execution to the receiver

---

### 🟣 Receivers

Create receiver classes such as:

* Light
* Projector
* AC
* CoffeeMachine

Each receiver should contain the actual business logic.

---

### 🟡 Invoker

Create a control panel class that:

* stores command objects
* triggers command execution
* remains independent from device implementations

---

## 🧩 Design Expectations

Your design should:

* Use **composition instead of direct dependency**
* Separate **request execution** from **business logic**
* Avoid hardcoded device operations
* Support runtime flexibility
* Allow easy addition of new commands
* Keep classes focused on single responsibilities

---

## ✅ Expected Outcome

* A flexible smart office system
* Ability to swap commands dynamically
* Loose coupling between control panel and devices
* Improved extensibility and maintainability
* Clean separation of concerns

---

## 🚀 Example Use Case (Conceptual)

The office administrator performs multiple operations:

* Turn lights ON
* Start projector
* Start coffee machine
* Turn AC ON

The same control panel:

* changes commands dynamically
* executes different operations
* remains unchanged internally

The invoker should only know:

```java id="jlyl11"
command.execute();
```

---

## 🔁 Challenge Extension (Optional)

Enhance the system by adding:

### ✅ Undo Functionality

Add:

```java id="9fw0y6"
undo()
```

to reverse previously executed actions.

---

### ✅ Macro Commands

Create one command that executes multiple commands together.

Example:

* MorningMeetingCommand

Which may:

* turn lights ON
* start projector
* start AC
* prepare coffee

---

### ✅ Command History

Store executed commands to support:

* multiple undo operations
* command tracking
* activity logging

---

## 📌 Key Insight

This activity demonstrates how the **Command Pattern** transforms actions into independent objects, allowing systems to become:

* flexible
* loosely coupled
* extensible
* maintainable

Most importantly:

> the object requesting the action becomes independent from the object performing the action.
