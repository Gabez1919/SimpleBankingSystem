# Simple Banking System (Java)

A clean, beginner/intermediate Java console project demonstrating object-oriented design, encapsulation, and basic input handling.

## Features

- Create a new bank account
- Deposit money
- Withdraw money (cannot withdraw more than balance)
- Display account balance
- Menu-based console UI using `Scanner`

## Project Structure

- `src/main/java/com/simplebanking/Account.java`
- `src/main/java/com/simplebanking/Bank.java`
- `src/main/java/com/simplebanking/Main.java`

## Requirements

- Java 17+ recommended
- Maven (optional but recommended for easy running)

## Run (Maven)

```bash
mvn -q compile exec:java
```

## Run (without Maven)

From the project root:

```bash
javac -d out src/main/java/com/simplebanking/*.java
java -cp out com.simplebanking.Main
```
