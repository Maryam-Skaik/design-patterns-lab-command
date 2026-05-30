# 🧪 Activity: Smart Office Automation System - Solution

## 🎯 Objective

This solution demonstrates how to design a **flexible and extensible office automation system** using the **Command Pattern**.

The main goal is to ensure that:

* Multiple smart devices can be controlled through a unified interface
* Requests are encapsulated as independent command objects
* The control panel remains independent from device implementations
* Commands can be changed dynamically at runtime
* New devices and operations can be added without modifying existing code
* The design remains **loosely coupled, scalable, and maintainable**

---

## 🧠 Solution Explanation

### Step 1: Identified Main Components

* `Command` (Command Interface)
* `LightOnCommand` (Concrete Command)
* `LightOffCommand` (Concrete Command)
* `ProjectorStartCommand` (Concrete Command)
* `ACStartCommand` (Concrete Command)
* `CoffeeMachineStartCommand` (Concrete Command)
* `Light` (Receiver)
* `Projector` (Receiver)
* `AC` (Receiver)
* `CoffeeMachine` (Receiver)
* `ControlPanel` (Invoker)
* `Main` (Client / Execution Class)

---

## ⚠️ Step 2: Identified the Core Problem

Without the Command Pattern:

* The control panel would directly control device logic
* Device operations would become tightly coupled to the UI layer
* Adding new devices would require modifying existing classes
* Large conditional statements could appear
* Undo functionality would be difficult to implement
* The system would become harder to maintain over time

### 💡 Key Insight

Office automation systems have two distinct concerns:

* **Request initiation** → pressing buttons and triggering actions
* **Request execution** → performing device-specific operations

These concerns should be separated to achieve flexibility and maintainability.

---

## 🧩 Step 3: Introduced Command Structure

The system defines a common contract:

```java
execute()
```

Optional support:

```java
undo()
```

These methods:

* Represent executable actions
* Allow different commands to be treated uniformly
* Enable runtime command swapping
* Support future extensibility

---

## 🧠 Step 4: Defined the Command Interface

### Interface: `Command`

Responsible for:

* Defining a unified contract for all commands
* Allowing different device actions to be interchangeable
* Decoupling request execution from request initiation

### Why this matters:

* The invoker depends only on the interface
* Concrete commands can change freely
* New commands can be introduced without affecting existing code

---

## 💡 Step 5: Light Commands

### Classes:

* `LightOnCommand`
* `LightOffCommand`

Focus:

* Encapsulating lighting operations

### Behavior:

* Turn office lights ON
* Turn office lights OFF

### Key Idea:

> The command does not perform the work itself. It delegates execution to the Light receiver.

---

## 📽️ Step 6: Projector Command

### Class: `ProjectorStartCommand`

Focus:

* Starting presentation equipment

### Behavior:

* Start projector

### Key Idea:

> The command acts as a wrapper around the projector operation.

---

## ❄️ Step 7: AC Command

### Class: `ACStartCommand`

Focus:

* Controlling office temperature systems

### Behavior:

* Start air conditioning

### Key Idea:

> The command encapsulates climate control actions independently from the control panel.

---

## ☕ Step 8: Coffee Machine Command

### Class: `CoffeeMachineStartCommand`

Focus:

* Automating coffee preparation

### Behavior:

* Start coffee machine

### Key Idea:

> The control panel does not know how coffee is prepared. It only executes a command.

---

## 🟣 Step 9: Receiver Role

### Receivers:

* `Light`
* `Projector`
* `AC`
* `CoffeeMachine`

Responsible for:

* Performing the actual business logic
* Knowing how each operation is executed

### Key Insight:

Receivers know **how** to perform actions.

Commands know **when** those actions should be executed.

---

## 🟡 Step 10: Invoker Role (Core of Command Pattern)

### Class: `ControlPanel`

Responsible for:

* Holding command objects
* Triggering command execution
* Remaining independent from device implementations

### Key Responsibilities:

* `setCommand()` → assigns commands dynamically
* `pressButton()` → executes commands
* `pressUndo()` → reverses previous actions

### Key Insight:

> The control panel never communicates directly with devices.

It only executes:

```java
command.execute();
```

---

## 🔁 Step 11: Runtime Command Switching

The system supports dynamic changes like:

```java
panel.setCommand(lightOn);

panel.setCommand(projectorStart);

panel.setCommand(coffeeStart);

panel.setCommand(acStart);
```

### What happens:

* Same control panel object is reused
* Only the command changes
* Different devices are controlled without changing invoker code

---

## 🔄 Step 12: Undo Functionality

The solution supports:

```java
pressUndo()
```

### How it works:

* The invoker stores the last executed command
* Undo delegates to:

```java
lastCommand.undo();
```

### Benefits:

* Reversible operations
* Better user experience
* Foundation for command history extensions

---

## 🧾 Step 13: Role of Main Class

The `Main` class acts as the **client demonstration layer**, responsible for:

* Creating receiver objects
* Creating command objects
* Wiring commands to receivers
* Assigning commands to the control panel
* Executing different office automation scenarios

### Key Observation:

Same method call:

```java
pressButton()
```

Produces different behavior depending on the currently assigned command.

---

## 🧩 UML Diagram Representation

```text
+----------------------+
|       Command        |
+----------------------+
| + execute()          |
| + undo()             |
+----------------------+
          ▲
 ---------------------------------------------------------
 |            |             |            |               |
 |            |             |            |               |
+-----------+ +-----------+ +----------+ +-----------+ +------------------+
| LightOn   | | LightOff  | |Projector | | ACStart   | | CoffeeMachine    |
| Command   | | Command   | | StartCmd | | Command   | | StartCommand     |
+-----------+ +-----------+ +----------+ +-----------+ +------------------+

          |
          v

+----------------------+
|     ControlPanel     |
+----------------------+
| - command            |
| - lastCommand        |
| + setCommand()       |
| + pressButton()      |
| + pressUndo()        |
+----------------------+

          ▲
          |
         Main
```

---

## ⚙️ Step 14: Java Implementation Highlights

* Encapsulates requests as objects
* Uses composition instead of direct dependency
* Supports runtime command swapping
* Supports undo functionality
* Keeps business logic inside receivers
* Follows Open/Closed Principle
* Promotes loose coupling between components

---

## 🧾 Example Execution Flow

```java
panel.setCommand(lightOn);
panel.pressButton();

panel.setCommand(projectorStart);
panel.pressButton();

panel.setCommand(coffeeStart);
panel.pressButton();

panel.setCommand(acStart);
panel.pressButton();
```

---

## 📌 Example Console Output

```text
Turning Lights ON
Office Light is ON
-------------------------

Starting Projector
Projector Started
-------------------------

Starting Coffee Machine
Coffee Machine Started
-------------------------

Starting AC
AC Started
-------------------------

Undo Last Command
AC Stopped
```

---

## 🚀 Advantages of This Design

* Supports runtime command changes
* Decouples UI from business logic
* Makes new devices easy to add
* Simplifies maintenance
* Enables undo functionality
* Improves scalability
* Encourages single responsibility classes
* Eliminates direct dependencies between control panel and devices

---

## 📌 Key Insight

This activity demonstrates the core idea of the **Command Pattern**:

> Encapsulate requests as objects so that the object requesting an action becomes independent from the object performing that action.

It is widely used in real-world systems such as:

* Remote controls
* GUI button actions
* Smart home systems
* Office automation systems
* Transaction processing systems
* Task scheduling systems
* Undo/redo frameworks
