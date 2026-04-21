package com.simplebanking;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Console entry point (menu-based).
 *
 * Keeps the UI concerns here, and delegates business logic to Bank/Account.
 */
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Simple Banking System ===");

            boolean running = true;
            while (running) {
                printMenu();
                int choice = readInt(scanner, "Choose an option (1-5): ");

                switch (choice) {
                    case 1 -> handleCreateAccount(bank, scanner);
                    case 2 -> handleDeposit(bank, scanner);
                    case 3 -> handleWithdraw(bank, scanner);
                    case 4 -> handleCheckBalance(bank, scanner);
                    case 5 -> {
                        System.out.println("Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid option. Please choose 1-5.");
                }

                if (running) {
                    System.out.println();
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("  1. Create account");
        System.out.println("  2. Deposit");
        System.out.println("  3. Withdraw");
        System.out.println("  4. Check balance");
        System.out.println("  5. Exit");
    }

    private static void handleCreateAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter new account number: ");
        String accountNumber = scanner.nextLine().trim();

        BigDecimal openingBalance = readMoney(scanner, "Enter opening balance (e.g., 100.00): ");
        try {
            Account created = bank.createAccount(accountNumber, openingBalance);
            System.out.println("Account created successfully.");
            System.out.println("Account Number: " + created.getAccountNumber());
            System.out.println("Balance: $" + created.getBalance());
        } catch (IllegalArgumentException ex) {
            System.out.println("Could not create account: " + ex.getMessage());
        }
    }

    private static void handleDeposit(Bank bank, Scanner scanner) {
        Account account = promptForExistingAccount(bank, scanner);
        if (account == null) return;

        BigDecimal amount = readMoney(scanner, "Enter deposit amount: ");
        try {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: $" + account.getBalance());
        } catch (IllegalArgumentException ex) {
            System.out.println("Deposit failed: " + ex.getMessage());
        }
    }

    private static void handleWithdraw(Bank bank, Scanner scanner) {
        Account account = promptForExistingAccount(bank, scanner);
        if (account == null) return;

        BigDecimal amount = readMoney(scanner, "Enter withdrawal amount: ");
        try {
            boolean ok = account.withdraw(amount);
            if (!ok) {
                System.out.println("Withdrawal denied: insufficient funds.");
                System.out.println("Current balance: $" + account.getBalance());
                return;
            }
            System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
        } catch (IllegalArgumentException ex) {
            System.out.println("Withdrawal failed: " + ex.getMessage());
        }
    }

    private static void handleCheckBalance(Bank bank, Scanner scanner) {
        Account account = promptForExistingAccount(bank, scanner);
        if (account == null) return;

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: $" + account.getBalance());
    }

    private static Account promptForExistingAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine().trim();

        Account account = null;
        try {
            account = bank.getAccount(accountNumber);
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid account number: " + ex.getMessage());
            return null;
        }

        if (account == null) {
            System.out.println("Account not found.");
        }
        return account;
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static BigDecimal readMoney(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                // BigDecimal(String) avoids floating point rounding issues.
                return new BigDecimal(line);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid amount (example: 25.50).");
            }
        }
    }
}
