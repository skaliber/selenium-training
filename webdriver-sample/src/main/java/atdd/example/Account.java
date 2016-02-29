// ============================================================================
//  File          : Account
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2007 Zoral, Ukraine
// ============================================================================
package atdd.example;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class Account {
    private Long id;
    private String user;
    private double amount;

    public Account(String user, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.user = user;
        this.amount = amount;
    }

    public String getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void reduceAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Not positive amount");
        }
        if (this.amount < amount) {
            throw new IllegalArgumentException("Not enough money");
        }
        this.amount -= amount;
    }

    public void increaseAmount(double amount) {
        this.amount += amount;
    }
}
