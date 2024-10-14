import java.util.concurrent.Semaphore;

public class Table {
    private final Semaphore[] forks = new Semaphore[5]; // 5 forks per table
    private final Philosopher[] philosophers = new Philosopher[5]; // 5 philosophers at each table
    private final int id;

    public Table(int id) {
        this.id = id;
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1); 
        }
    }

    public int getId() {
        return this.id;
    }

    // Add a philosopher to this table
    public void addPhilosopher(Philosopher philosopher, int index) {
        philosophers[index] = philosopher;
    }

    public boolean fork_available(Philosopher philosopher) throws InterruptedException {
        int leftFork = philosopher.getLabel().charAt(0) % 5;
        int rightFork = (leftFork + 1) % 5;
    
        forks[leftFork].acquire();
        System.out.println(philosopher.getLabel() + "picked up the left fork");
    
        try {
            forks[rightFork].acquire();
            System.out.println(philosopher.getLabel() + " picked up both forks."); // both forked picked
            return true; 
        } catch (InterruptedException e) {
            forks[leftFork].release();
            throw e;
        }
    }

    public boolean isDeadlocked() {
        for (Philosopher philosopher : philosophers) {
            if (philosopher != null && !philosopher.isHungry()) {
                return false;
            }
        }
        return true; 
    }

    public void moveToSixthTable(Philosopher philosopher) {
        System.out.println(philosopher.getLabel() + " moves to the sixth table.");
    }
}
