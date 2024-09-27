import java.util.Random;

public class TableMonitor {
    private int philosophersAtTable6 = 0;
    private static final int MAX_PHILOSOPHERS_TABLE_6 = 5;
    private final Random random = new Random();

    public synchronized boolean checkForDeadlock() {
        // Simulate deadlock with a small probability (5%)
        return random.nextInt(100) < 5;
    }

    public synchronized void moveToTable6(Philosopher philosopher) {
        if (philosophersAtTable6 < MAX_PHILOSOPHERS_TABLE_6) {
            philosophersAtTable6++;
            System.out.println("Philosopher " + philosopher.getId() + " moved to Table 6.");
            if (philosophersAtTable6 == MAX_PHILOSOPHERS_TABLE_6) {
                System.out.println("Table 6 is now full and deadlocked.");
                System.out.println("Philosopher " + philosopher.getId() + " was the last to move.");
            }
        }
    }
}
