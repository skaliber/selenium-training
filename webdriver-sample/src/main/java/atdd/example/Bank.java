// ============================================================================
//  File          : Bank
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2007 Zoral, Ukraine
// ============================================================================
package atdd.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class Bank {
    private static final Bank instance = new Bank();
    private Map<Long, Account> accounts = new HashMap<Long, Account>();

    public static Bank getInstance() {
        return instance;
    }

    private Bank() {
    }

    public void addAccount(Account account) {
        long id = System.nanoTime();
        account.setId(id);
        accounts.put(id, account);
    }

    public int getAccountsCount() {
        return accounts.size();
    }

    public Collection<Account> getAccounts() {
        return accounts.values();
    }

    public void moveMoney(Account fromAccount, Account toAccount, double amount) {
        fromAccount.reduceAmount(amount);
        toAccount.increaseAmount(amount);
    }
}
