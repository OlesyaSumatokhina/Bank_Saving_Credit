

import org.example.CreditAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(3000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.add(-3000);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldPayToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                3500,
                2_000,
                15
        );

        account.pay(3000);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldPayToNegativeAmount() {
        CreditAccount account = new CreditAccount(
                3500,
                5_000,
                15
        );
        boolean actual = account.pay(-3000);
        boolean expected = false;

        Assertions.assertEquals(false, actual);
    }

    @Test
    public void shouldPayBalanceMoreLimit() {
        CreditAccount account = new CreditAccount(
                3500,
                500,
                15
        );
        boolean actual = account.pay(1_000);

        Assertions.assertEquals(true, actual);
    }

    @Test
    public void shouldPayLimitMoreBalance() {
        CreditAccount account = new CreditAccount(
                3500,
                4500,
                15
        );
        boolean actual = account.pay(1_000);

        Assertions.assertEquals(false, actual);
    }


    @Test
    public void shouldYearChangeToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                1000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldYearChangeToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        account.setBalance(-200);
        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void testSetCreditLimit() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.setCreditLimit(3000);

        Assertions.assertEquals(3_000, account.getCreditLimit());
    }

    @Test
    public void testIllegalArgumentExceptionRate() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CreditAccount(
                            100,
                            100,
                            -5);
                });
    }

    @Test
    public void testIllegalArgumentExceptionInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CreditAccount(
                            -100,
                            100,
                            5);
                });
    }

    @Test
    public void testIllegalArgumentExceptionCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CreditAccount(
                            100,
                            -100,
                            5);
                });
    }
}
