import java.util.Random;

public class Philosopher {
    private final Table table;
    private final String label;
    private static final Random random = new Random();
    private boolean isThinking;
    private boolean isHungry;
    private boolean isEating;

    public Philosopher(Table table, String label) {
        this.table = table;
        this.label = label;
        this.isThinking = true; // Initially thinking
        this.isHungry = false;
        this.isEating = false;
    }

    public String getLabel() {
        return this.label;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void simulate_philosopher() {
        while (true) {
            try {
                think();
                pickUpForks();
                eat();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void think() throws InterruptedException {
        System.out.println(this.label + " is thinking on table " + this.table.getId());
        Thread.sleep(random.nextInt(1000)); // Thinking for random time
        isThinking = false;
        isHungry = true;
    }

    private void pickUpForks() throws InterruptedException {
        isHungry = true;
        System.out.println(label + " is hungry.");
        if (table.fork_available(this)) {
            isEating = true;
            isHungry = false;
            System.out.println(label + " picked up both forks.");
        } else {
            checkDeadlock(); // Check for deadlock if unable to eat
        }
    }

    private void eat() throws InterruptedException {
        System.out.println(this.label + " is eating.");
        Thread.sleep(5000); // Eating for 5 seconds
        isEating = false;
        isThinking = true;
    }

    private void checkDeadlock() {
        if (table.isDeadlocked()) {
            System.out.println("Deadlock detected at table " + table.getId() + "!");
            table.moveToSixthTable(this); // Handle moving to sixth table
        }
    }
}
