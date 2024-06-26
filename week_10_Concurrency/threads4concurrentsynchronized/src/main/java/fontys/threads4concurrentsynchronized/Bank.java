package fontys.threads4concurrentsynchronized;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A bank with a number of bank accounts that uses synchronization primitives.
 */
public class Bank {

    private final double[] accounts;
    private AtomicInteger counter;

    /**
     * Constructs the bank.
     *
     * @param n the number of accounts
     * @param initialBalance the initial balance for each account
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Transfers money from one account to another.
     * Here you clearly see the use of synchronized word in the method signature.
     * That block the method from other threads.
     * Until the work of the current thread is done.
     * This approach "synchronized" will automatically lock the method and unlock it.
     * .
     * When a condition is not met, you can let the thread waits by using "wait()" until resources are available.
     * Only then and after "notifyAll()" is called to release the waiting threads.
     *
     * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     * @throws java.lang.InterruptedException
     */
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) {
            wait();
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        notifyAll();
    }

    /**
     * Gets the sum of all account balances.
     *
     * @return the total balance
     */
    public synchronized double getTotalBalance() {
        double sum = 0;

        for (double a : accounts) {
            sum += a;
        }

        return sum;
    }

    /**
     * Gets the number of accounts in the bank.
     *
     * @return the number of accounts
     */
    public int size() {
        return accounts.length;
    }

    public void doSomething() {

        // Non-critical code 
        synchronized (this) {

        }

    }
}
