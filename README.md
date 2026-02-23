# SST28 LLD101 — SOLID Refactoring Assignment

This repository contains refactored solutions for Exercises 01–06 of the SOLID design assignment.
Each exercise improves the given code by fixing design issues while preserving original behavior.

---

## Completed Exercises

**Ex01 — SRP**
Separated parsing, validation, persistence, and printing responsibilities into dedicated classes.

**Ex02 — SRP**
Extracted invoice generation, tax calculation, discount logic, printing, and storage into independent components.

**Ex03 — OCP**
Replaced conditional rule chain with pluggable rule classes implementing a common interface.

**Ex04 — OCP**
Removed switch-case pricing logic and introduced strategy classes for room and add-on pricing.

**Ex05 — LSP**
Enforced contract consistency in exporters by moving validation into base class and standardizing subclass behavior.

**Ex06 — LSP**
Unified notification sending logic through a template method in base class to ensure consistent behavior across channels.

---

## Structure

```
SST28-LLD101/
 └── SOLID/
      ├── Ex1/src
      ├── Ex2/src
      ├── Ex3/src
      ├── Ex4/src
      ├── Ex5/src
      └── Ex6/src
```

Each exercise compiles and runs independently from its own `src` folder.

---

## How to Run

Navigate to any exercise folder:

```
cd SOLID/ExX/src
javac *.java
java Main
```

---

## Objective

The goal of this assignment is to refactor poorly designed code into maintainable, extensible, and testable designs using SOLID principles while keeping functionality unchanged.
