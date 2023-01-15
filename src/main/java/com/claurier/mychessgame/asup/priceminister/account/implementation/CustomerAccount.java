package com.claurier.mychessgame.asup.priceminister.account.implementation;


import com.claurier.mychessgame.asup.priceminister.account.Account;
import com.claurier.mychessgame.asup.priceminister.account.AccountRule;
import com.claurier.mychessgame.asup.priceminister.account.IllegalBalanceException;

public class CustomerAccount implements Account {

    private Double balance = 0d;

    public CustomerAccount() {
        this.balance = Double.valueOf(0.0);
    }

    public CustomerAccount(Double balance) {
        this.balance = balance;
    }

    public void add(Double addedAmount)  {
        if (addedAmount == null)
            throw new IllegalArgumentException("Amount is null");
        if (addedAmount < 0)
            throw new IllegalArgumentException("Amount is nagetive, better use......");
        balance += addedAmount;
    }

    public Double getBalance() {
        return this.balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule)
    		throws IllegalBalanceException {
        if (withdrawnAmount == null) {
            throw new IllegalArgumentException("withdrawnAmount is null");
        }
        if (rule == null) {
            throw new IllegalArgumentException("rule is null");
        }
        if (withdrawnAmount < 0) {
            throw new IllegalArgumentException("withdrawnAmount is negative, to add money, use Account#add");
        }

        double newBalance = this.balance - withdrawnAmount;
        if (rule.withdrawPermitted(newBalance)) {
            this.balance = newBalance;
        } else {
            throw new IllegalBalanceException(newBalance);
        }
        return balance;
    }

}
