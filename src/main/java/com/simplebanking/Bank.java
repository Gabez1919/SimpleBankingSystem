package com.simplebanking;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Stores and manages multiple accounts.
 *
 * This class keeps the "collection of accounts" responsibility separate from the
 * Account class itself (single-responsibility principle).
 */
public class Bank {
    private final Map<String, Account> accountsByNumber = new HashMap<>();

    /**
     * Creates a new account with the given account number.
     *
     * @throws IllegalArgumentException if the account already exists
     */
    public Account createAccount(String accountNumber, BigDecimal openingBalance) {
        String key = normalizeAccountNumber(accountNumber);
        if (accountsByNumber.containsKey(key)) {
            throw new IllegalArgumentException("Account already exists: " + key);
        }

        Account account = new Account(key, openingBalance);
        accountsByNumber.put(key, account);
        return account;
    }

    public Account getAccount(String accountNumber) {
        String key = normalizeAccountNumber(accountNumber);
        return accountsByNumber.get(key);
    }

    public boolean accountExists(String accountNumber) {
        return getAccount(accountNumber) != null;
    }

    public Collection<Account> getAllAccounts() {
        return Collections.unmodifiableCollection(accountsByNumber.values());
    }

    private static String normalizeAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number must not be blank");
        }
        return accountNumber.trim();
    }
}
