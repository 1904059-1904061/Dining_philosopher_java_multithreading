public class Runsimulation {
    private int time_passed = 0;
    private final int num_tables;
    private final int philosophers_per_table;

    public Runsimulation() {
        this.num_tables = 5; // 5 main tables
        this.philosophers_per_table = 5; // 5 philosophers per table
    }

    public void startSimulation() {
        Thread thread_for_time = new Thread(this::simulate);
        thread_for_time.start();

        Table[] tables = new Table[num_tables + 1]; // 5 tables + 1 sixth table
        for (int i = 1; i <= num_tables; i++) {
            tables[i] = new Table(i); // Initialize each table
        }
        tables[num_tables] = new Table(num_tables + 1); 

        int cnt = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                String philosopher_label = Character.toString((char) (cnt + 65)); 
                Philosopher philosopher = new Philosopher(tables[i], philosopher_label);
                
                // Add philosopher to the table
                tables[i].addPhilosopher(philosopher, j - 1); // Store philosophers at table
                
                Thread philosopher_thread = new Thread(() -> philosopher.simulate_philosopher());
                philosopher_thread.start();
                cnt++;
            }
        }
    }

    private void simulate() {
        while (true) {
            try {
                Thread.sleep(1000); // Increment time by 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            time_passed++;
        }
    }
}
