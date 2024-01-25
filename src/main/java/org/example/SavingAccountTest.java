package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SavingAccountTest {

    @Test
    public void showIllLegalArgumentRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            new SavingAccount(10, 100, 10_000, -5);
        });
    }

    @Test
    public void showIllLegalArgumentInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            new SavingAccount(-10, 100, 10_000, 5);
        });
    }

    @Test
    public void showIllLegalArgumentMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            new SavingAccount(10, 100, -10_000, 5);
        });
    }

    @Test
    public void showIllLegalArgumentMinBalanceAndMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            new SavingAccount(10, 100, 10, 5);
        });
    }

    @Test
    public void showIllLegalArgumentMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            new SavingAccount(10, -100, 10_000, 5);
        });
    }

    @Test
    public void showNewBalanceAfterPay() {
        SavingAccount payAccount = new SavingAccount(
                2_000, 100, 10_000, 5
        );
        boolean actual = false;
        boolean expected = payAccount.pay(1950);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void checkBalanceNullAfterPay() {
        SavingAccount payAccount = new SavingAccount(
                0, 100, 10_000, 5
        );
        boolean actual = false;
        boolean expected = payAccount.pay(500);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void checkBalanceAfterNegativePay() {
        SavingAccount payAccount = new SavingAccount(
                2_000, 100, 10_000, 5
        );
        boolean actual = false;
        boolean expected = payAccount.pay(-500);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void showNewBalanceAfterPayMaxSum() {
        SavingAccount payAccount = new SavingAccount(
                2_000, 100, 10_000, 5
        );
        boolean actual = false;
        boolean expected = payAccount.pay(2100);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void showAddNegativeAmount() {
        SavingAccount account = new SavingAccount(100, 1_000, 10_000, 7);

        boolean actual = false;
        boolean expected = account.add(-3_000);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void showAddMoreMaxBalanceAmount() {
        SavingAccount account = new SavingAccount(100, 1_000, 10_000, 7);

        boolean actual = false;
        boolean expected = account.add(11_000);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void showYearChange() {

        SavingAccount account = new SavingAccount(
                200,
                100,
                10_000,
                15
        );
        int actual = 30;
        int expected = account.yearChange();
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void showYearChangeNull() {

        SavingAccount account = new SavingAccount(
                0,
                1_000,
                10_000,
                15
        );
        int actual = 0;
        int expected = account.yearChange();
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void showCurrentMinBalance() {
        SavingAccount account = new SavingAccount(100, 100, 2_000, 5);

        int actual = account.getMinBalance();
        int expected = 100;
        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void showCurrentMaxBalance() {
        SavingAccount account = new SavingAccount(100, 200, 2_000, 5);

        int actual = account.getMaxBalance();
        int expected = 2_000;
        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void showMinBalanse() {
        SavingAccount account = new SavingAccount(100, 10, 10_000, 5);
        account.setMinBalance(10);
        int actual = account.minBalance;
        Assertions.assertEquals(10, actual);
    }

    @Test
    public void showMaxBalance() {
        SavingAccount account = new SavingAccount(100, 10, 10_000, 5);
        account.setMaxBalance(10_000);
        int actual = account.maxBalance;
        Assertions.assertEquals(10_000, actual);
    }

}