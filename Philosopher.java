import java.util.Random;

public class Philosopher implements Runnable {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private final TableMonitor monitor;
    private final Random random = new Random();

    public Philosopher(int id, Fork leftFork, Fork rightFork, TableMonitor monitor) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Think for a random amount of time.
                think();

                // Get hungry and try to pick up forks.
                pickUpLeftFork();
                pickUpRightFork();

                // Eat for a random amount of time.
                eat();

                // Put down the forks.
                putDownForks();

                // Check for deadlock and move if needed
                if (monitor.checkForDeadlock()) {
                    monitor.moveToTable6(this);
                    return;  // Philosopher moved to table 6, exit loop
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        int thinkTime = random.nextInt(10) + 1;
        System.out.println("Philosopher " + id + " is thinking for " + thinkTime + " seconds.");
        Thread.sleep(thinkTime * 1000);
    }

    private void pickUpLeftFork() throws InterruptedException {
        leftFork.pickUp();
        System.out.println("Philosopher " + id + " picked up left fork.");
        Thread.sleep(4000);  // Wait 4 seconds
    }

    private void pickUpRightFork() throws InterruptedException {
        rightFork.pickUp();
        System.out.println("Philosopher " + id + " picked up right fork.");
    }

    private void eat() throws InterruptedException {
        int eatTime = random.nextInt(5) + 1;
        System.out.println("Philosopher " + id + " is eating for " + eatTime + " seconds.");
        Thread.sleep(eatTime * 1000);
    }

    private void putDownForks() {
        leftFork.putDown();
        rightFork.putDown();
        System.out.println("Philosopher " + id + " put down both forks.");
    }

    public int getId() {
        return id;
    }
}
