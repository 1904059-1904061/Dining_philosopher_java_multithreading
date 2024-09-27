public class Simulator {
    public static void main(String[] args) {
        int numberOfPhilosophers = 5;
        int numberOfTables = 5;

        Fork[] forks = new Fork[numberOfPhilosophers * numberOfTables];
        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers * numberOfTables];
        TableMonitor monitor = new TableMonitor();

        // Initialize forks
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork();
        }

        // Initialize philosophers and assign forks
        for (int i = 0; i < philosophers.length; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % numberOfPhilosophers];
            philosophers[i] = new Philosopher(i, leftFork, rightFork, monitor);
            new Thread(philosophers[i]).start();
        }
    }
}
