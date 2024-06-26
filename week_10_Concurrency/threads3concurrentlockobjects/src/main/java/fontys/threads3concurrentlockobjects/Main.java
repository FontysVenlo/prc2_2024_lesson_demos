package fontys.threads3concurrentlockobjects;

/**
 * This program shows how multiple threads access a data structure.
 *
 * @version 1.32 2018-04-10
 * @author Cay Horstmann
 */
public class Main {

    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        var bank = new Bank(NACCOUNTS, INITIAL_BALANCE);

        /*
            Here you can see that with the same code from the previous example,
            Only one thread at a time can use the transfer method.
         */
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
                    System.out.println(e.getMessage());
                }
            };

            var t = new Thread(r);
            t.start();
        }
    }
}
