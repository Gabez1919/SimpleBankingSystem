<<<<<<< HEAD
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
=======
# SimpleBankingSystem
This Java project simulates a simple banking system with support for different types of accounts. It demonstrates the use of object-oriented programming (OOP) concepts such as inheritance, polymorphism, and encapsulation.

## Features

- Create and manage different types of accounts:
  - BankAccount (base class)
  - CheckingAccount (subclass)
  - SavingsAccount (subclass)
- Deposit and withdraw operations
- Balance tracking
- Transaction logic built into class methods
- Console-based testing

## Project Structure

src/banking/
- BankAccount.java        // Base class with common properties and methods
- CheckingAccount.java    // Extends BankAccount, with account-specific logic
- SavingsAccount.java     // Extends BankAccount, with savings-specific behavior

## What I Learned

- Implementing OOP principles in a structured Java program
- Building reusable code with inheritance and overriding
- Applying encapsulation to secure account data
- Structuring code into multiple interrelated classes
- Testing object behavior using Java main methods

## How to Run

1. Clone or download the repository
2. Open the project in an IDE like Eclipse or IntelliJ
3. Compile the classes in src/banking
4. Create a main method in a new file to test the features (or integrate it with a UI/API)

## Future Plans

- Add Main.java file with a full menu-based user interface
- Create persistent storage using file I/O or databases
- Add transaction history and logging
- Improve error handling and input validation
- Connect to a REST API or GUI for user interaction
>>>>>>> 797a8336e8b28594199ea975d8905823c13ad5e8
