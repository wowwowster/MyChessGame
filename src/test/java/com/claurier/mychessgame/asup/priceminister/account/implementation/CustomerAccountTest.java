package com.claurier.mychessgame.asup.priceminister.account.implementation;


import com.claurier.mychessgame.asup.priceminister.account.Account;
import com.claurier.mychessgame.asup.priceminister.account.AccountRule;
import com.claurier.mychessgame.asup.priceminister.account.IllegalBalanceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * <p>
 * We want to see how you "think code", and how you organize and structure a simple application.
 * <p>
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 */
public class CustomerAccountTest {

    Account customerAccount;
    AccountRule rule;

    /**
     * @throws Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
    }

    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        Double balanceToTest = customerAccount.getBalance();
        assertNotNull(balanceToTest);
        assertEquals(balanceToTest, Double.valueOf(0.0));
    }

    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        double ten = 10;
        customerAccount.add(ten);
        Double balanceToTest = customerAccount.getBalance();
        assertEquals(new Double(ten), balanceToTest);
    }

    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() {
        Double withdrawnAmount = Double.valueOf(15);
        assertThrows(IllegalBalanceException.class,
                () -> customerAccount.withdrawAndReportBalance(withdrawnAmount, rule), "Blah blah");
       /* IllegalBalanceException thrown = assertThrows(IllegalBalanceException.class,
                () -> customerAccount.withdrawAndReportBalance(withdrawnAmount, rule), "Blah blah");
                si test le message du type d'exception
        */
    }

    // Also implement missing unit tests for the above functionalities.
    @Test
    public void testAddNullParameter()  {
        assertThrows(IllegalArgumentException.class, () -> customerAccount.add(null), "Blah blah");
    }

}
