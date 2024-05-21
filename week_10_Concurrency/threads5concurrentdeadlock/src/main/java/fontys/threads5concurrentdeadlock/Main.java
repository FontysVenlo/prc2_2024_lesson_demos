package fontys.threads5concurrentdeadlock;

/**
 * This program shows how multiple threads access a data structure.
 *
 * @version 1.32 2018-04-10
 * @author Cay Horstmann
 */
public class Main {

    public static final int NACCOUNTS = 10;
    public static final double INITIAL_BALANCE = 1000;

    // Here we set high MAX_AMOUNT, so we produce the deadlock.
    public static final double MAX_AMOUNT = 2 * INITIAL_BALANCE;

    public static final int DELAY = 10;

    public static void main(String[] args) {
        var bank = new Bank(NACCOUNTS, INITIAL_BALANCE);

        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;

            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                }
            };

            var t = new Thread(r);
            t.start();
        }
    }
}



// Account 1 = 200$
// Acount 2 = 300$

// trans 400$ from 2 to 1
// trans 300$ from 1 to 2 





