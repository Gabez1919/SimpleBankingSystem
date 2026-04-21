package com.simplebanking;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a single bank account.
 *
 * Key ideas:
 * - Encapsulation: fields are private, behavior is exposed via methods.
 * - Validation: deposit/withdraw protect account invariants.
 */
public class Account {
    private final String accountNumber;
    private BigDecimal balance;

    public Account(String accountNumber, BigDecimal openingBalance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("accountNumber must not be blank");
        }
        this.accountNumber = accountNumber.trim();
        this.balance = normalizeAmount(openingBalance == null ? BigDecimal.ZERO : openingBalance);
        if (this.balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("openingBalance must be >= 0");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Deposits a positive amount into the account.
     */
    public void deposit(BigDecimal amount) {
        BigDecimal normalized = normalizeAmount(amount);
        if (normalized.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be > 0");
        }
        balance = balance.add(normalized);
    }

    /**
     * Withdraws a positive amount if sufficient funds exist.
     *
     * @return true if withdrawal succeeded, false otherwise
     */
    public boolean withdraw(BigDecimal amount) {
        BigDecimal normalized = normalizeAmount(amount);
        if (normalized.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be > 0");
        }
        if (normalized.compareTo(balance) > 0) {
            return false;
        }
        balance = balance.subtract(normalized);
        return true;
    }

    private static BigDecimal normalizeAmount(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount must not be null");
        }
        // Banking amounts are typically represented with 2 decimal places.
        return amount.setScale(2, RoundingMode.HALF_UP);
    }
}
