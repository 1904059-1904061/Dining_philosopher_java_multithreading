import java.io.*; 
import java.util.*; 
public class Runsimulation {
    private int time_passed = 0;
    private int num_tables;
    private int philosophers_per_table;
    // private String[] philsopher_label = new String[25];
    public Runsimulation(){
        this.num_tables = 5;
        this.philosophers_per_table = 5;
    }
    public void startSimulation(){
    Thread thread_for_time = new Thread(this::simulate);
    Table[] tables = new Table[num_tables+1];
    for (int i=1;i<=num_tables;i++){
        tables[i] = new Table(i);
    }
    for(int i = 1;i<=5;i++){
        for(int j=1;j<=5;j++){
           String philsopher_label = Character.toString((char)65);
           Philosopher philosopher = new Philosopher(tables[i], philsopher_label);
           Thread philosopher_thread = new Thread(() -> philosopher.simulate_philosopher());
           philosopher_thread.start();
        }
    }
  }
  private void simulate() {
    while (true) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        time_passed++;
    }
  }
}
