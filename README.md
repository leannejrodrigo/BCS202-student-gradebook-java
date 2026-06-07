# 📚 Student Gradebook System

> A console-based Java application for managing student records, assigning grades, calculating averages, and generating academic reports — with persistent file storage and robust exception handling.

---

## 📋 Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [File Handling](#file-handling)
- [Exception Handling](#exception-handling)
- [OOP Concepts Used](#oop-concepts-used)
- [Team Members](#team-members)

---

## About the Project

This project was developed as part of **BCS 202 – Introduction to Computer Science II** at the School of Engineering, Applied Sciences, and Technology.

The Student Gradebook System is a Java console application that allows teachers to manage student academic data. Teachers can add students, assign subject-wise grades, calculate averages, and generate full reports. All data is saved to a file and reloaded on the next run, so nothing is lost between sessions.

---

## Features

- ➕ **Add Students** — Register students by name into the gradebook
- 📝 **Assign Grades** — Assign grades per subject for any student
- 📊 **Generate Reports** — View each student's name, subjects, grades, and average
- 🗑️ **Delete Students** — Remove a student from the gradebook
- 💾 **Persistent Storage** — Data is saved to and loaded from a file automatically
- 🛡️ **Input Validation** — Handles invalid inputs gracefully with clear error messages

---

## Project Structure

```
StudentGradebookSystem/
│
├── src/
│   ├── GradebookApp.java       # Main entry point, menu loop
│   ├── Gradebook.java          # Core logic: add, delete, assign, report, file I/O
│   ├── Student.java            # Student class with name, grades, and average calculation
│   └── Subject.java            # Subject class with subject name
│
├── data/
│   └── gradebook.txt           # Persistent data file (auto-generated on first run)
│
└── README.md
```

> **Note:** `gradebook.txt` is created automatically when you first run the application. You do not need to create it manually.

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A terminal / command prompt

### Compile

```bash
cd src
javac *.java
```

### Run

```bash
java GradebookApp
```

---

## Usage

Once running, the application presents a menu:

```
Enter choice:
1. Add student
2. Assign Grade
3. Generate Report
4. Delete Student
5. Exit
```

**Example walkthrough:**

1. Select `1` → Enter `Sara Ali` → Student is added and saved
2. Select `2` → Enter `Sara Ali` → Enter subject `Math` → Enter grade `88.5`
3. Select `3` → A full report is printed with averages
4. Select `5` → Exit; data is preserved for next session

---

## File Handling

Student data is stored persistently using Java's `FileWriter` and `Scanner` classes.

- On **startup**, data is loaded from `gradebook.txt` via `loadData()`
- After every **add, assign, or delete**, data is written back via `writeData()`
- If the file does not exist on first run, it is created automatically

---

## Exception Handling

The application handles the following exceptions:

| Exception | Scenario |
|-----------|---------|
| `FileNotFoundException` | Data file is missing on load |
| `IOException` | Error during file read/write |
| `InputMismatchException` | User enters a non-numeric menu choice |
| `IllegalArgumentException` | Empty name, empty subject, or grade out of range (0–100) |

---

## OOP Concepts Used

| Concept | Where Applied |
|---------|--------------|
| **Classes & Objects** | `Student`, `Subject`, `Gradebook` |
| **Inheritance** | `Student` extends `Gradebook` |
| **Encapsulation** | Private fields with getters in all classes |
| **Inner Class** | `Grade` inner class inside `Student` |
| **Exception Handling** | Try/catch blocks throughout `GradebookApp` and `Student` |
| **File I/O** | `FileWriter`, `Scanner`, `File` classes in `Gradebook` |

---

## Team Members

| Student ID | Name |
|------------|------|
| 202300037989 | Yasmin Issa |
| 20220002536 | Maryam Al-Yaseen |
| 20230003378 | Fasmin Nizar |
| 20230003626 | Sidra Sheikh |
| 20220001971 | Sulafa Duodi |

---

*BCS 202 – Introduction to Computer Science II | School of Engineering, Applied Sciences, and Technology*
