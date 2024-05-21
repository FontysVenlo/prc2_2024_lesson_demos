package fontys.threads1parallel;

/**
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 */
public class Main {

    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {

        // Create Bank object
        var bank = new Bank(4, 100000);

        // Create the first thread
        Runnable task1 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0, 1, amount);
                    Thread.currentThread().setName("Ibi");
                    System.out.println("The thread name is: " + Thread.currentThread().getName());
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());;
            }
        };

        // Create the second thread
        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(2, 3, amount);
                    //System.out.println("The thread name is: " + Thread.currentThread().getName());
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };

        // Does not start new thread, it start a new task within the same thread
        // task1.run();
        // task2.run();
        Thread thread = new Thread(task1);
        thread.start();
        new Thread(task2).start();
    }
}
