# Task Scheduler using Queue (COMP47500)

## Overview

This project implements a **Queue Abstract Data Type (ADT)** in Java and applies it to a **Task Scheduling system**.

The scheduler processes tasks using the **First-In-First-Out (FIFO)** principle, ensuring tasks are executed in the same order they are added.

The project also includes **performance experiments** to evaluate the efficiency of queue operations.

---

## Features

* Generic queue implementation in Java
* Linked List Queue implementation
* Array Queue implementation
* Task Scheduler simulation
* Performance experiments for queue operations
* Time complexity analysis

---

## Project Structure

```
Task-Scheduler/
│
├── src/
│   └── comp47500/advds/
│       ├── Task.java
│       ├── MyArrayQueue.java
│       ├── MyLinkedQueue.java
│       └── TaskScheduler.java
│
├── test/
│   └── ExperimentRunner.java
│
├── uml/
│   └── class-diagram.png
│
└── README.md
```

---

## Requirements

* Java 17 or later
* Command Line / Terminal

---

## Compilation

Compile all Java files using:

```bash
javac -d out src/comp47500/advds/*.java test/*.java
```

This command compiles the source files and places the `.class` files inside the **out** directory.

---

## Running the Task Scheduler

Run the scheduler using:

```bash
java -cp out comp47500.advds.TaskScheduler
```

Example output:

```
Adding tasks to scheduler...

Processing tasks...

Processing: Print Research Paper (duration: 10ms)
Processing: Compile Java Program (duration: 5ms)
Processing: Send Email Report (duration: 3ms)
Processing: Backup Files (duration: 7ms)

All tasks completed.
```

---

## Running Performance Experiments

To evaluate queue performance, run:

```bash
java -cp out ExperimentRunner
```

The experiment measures execution time for:

* Enqueue operations
* Dequeue operations
* Mixed workload operations

for different task sizes.

---

## Complexity Analysis

| Operation | Time Complexity |
| --------- | --------------- |
| Enqueue   | O(1)            |
| Dequeue   | O(1)            |
| Peek      | O(1)            |
| Space     | O(n)            |

The linked list queue maintains constant-time enqueue and dequeue operations by keeping references to both the **front** and **rear** nodes.

---

## Authors

**Rahul Mirashi**
**Soham Maji**

MSc Computer Science
University College Dublin
