package org.example;

/**
 * Кредитный счёт
 * Может иметь баланс вплоть до отрицательного, но до указанного кредитного лимита.
 * Имеет ставку - количество процентов годовых на сумму на балансе, если она меньше нуля.
 */
public class CreditAccount extends Account {


    protected int creditLimit;

    public int getCreditLimit() {
        return creditLimit;
    }


    /**
     * Создаёт новый объект кредитного счёта с заданными параметрами.
     * Если параметры некорректны (кредитный лимит отрицательный и так далее), то
     * должно выкидываться исключения вида IllegalArgumentException.
     *
     * @param initialBalance - неотрицательное число, начальный баланс для счёта
     * @param creditLimit    - неотрицательное число, максимальная сумма которую можно задолжать банку
     * @param rate           - неотрицательное число, ставка кредитования для расчёта долга за отрицательный баланс
     */
    public CreditAccount(int initialBalance, int creditLimit, int rate) {
        super();

        if (rate < 0) {
            throw new IllegalArgumentException(
                    "Ставка кредитования не может быть отрицательной, а у вас: " + rate
            );
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Начальный баланс не может быть отрицательным, а у вас: " + initialBalance
            );
        }
        if (creditLimit < 0) {
            throw new IllegalArgumentException(
                    "Максимальная сумма задолженности перед банком не может быть отрицательной, а у вас: " + creditLimit
            );
        }

        this.balance = initialBalance;
        this.creditLimit = creditLimit;
        this.rate = rate;
    }

    /**
     * Операция оплаты с карты на указанную сумму.
     * В результате успешного вызова этого метода, баланс должен уменьшиться
     * на сумму покупки. Если же операция может привести к некорректному
     * состоянию счёта (например, баланс может уйти меньше чем лимит), то операция должна
     * завершиться вернув false и ничего не поменяв на счёте.
     *
     * @param amount - сумма покупки
     * @return true если операция прошла успешно, false иначе.
     */
    @Override
    public boolean pay(int amount) {
        if (amount <= 0) {
            return false;
        }

        if (balance - amount >= creditLimit) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Операция пополнения карты на указанную сумму.
     * В результате успешного вызова этого метода, баланс должен увеличиться
     * на сумму покупки. Если же операция может привести к некорректному
     * состоянию счёта, то операция должна
     * завершиться вернув false и ничего не поменяв на счёте.
     *
     * @param amount - сумма пополнения
     * @param amount
     * @return true если операция прошла успешно, false иначе.
     * @return
     */
    @Override
    public boolean add(int amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    /**
     * Операция расчёта процентов на отрицательный баланс счёта при условии, что
     * счёт не будет меняться год. Сумма процентов приводится к целому
     * числу через отбрасывание дробной части (так и работает целочисленное деление).
     * Пример: если на счёте -200 рублей, то при ставке 15% ответ должен быть -30.
     * Пример 2: если на счёте 200 рублей, то при любой ставке ответ должен быть 0.
     *
     * @return
     */

    @Override
    public int yearChange() {
        if (balance < 0) {
            return balance * rate / 100;
        } else {
            return 0;
        }
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }
}