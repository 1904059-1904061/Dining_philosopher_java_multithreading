import java.util.Random;

public class Philosopher {
    private final Table table;
    private final String label;
    private static final Random random = new Random();
    private boolean isThinking; 
    private boolean isHungry;   
    private boolean isEating;   
    public Philosopher(Table table,String label){
        this.table = table;
        this.label = label;
        this.isThinking = true; // initially thinking
        this.isHungry = false;
        this.isEating = false;
    }
    public String getLabel(){
        return this.label;
    }
    public void simulate_philosopher() {
        while (true) {
        try{
            think();
            pickUpForks();
            eat(); 
            
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
     }
    }
    private void think() throws InterruptedException{
       System.out.println(this.label + " is thinking on table "+ this.table.getId());
       Thread.sleep(1000);    // thinking for bla bla seconds
    }
    private void pickUpForks() throws InterruptedException {
        isHungry = true; 
        System.out.println(label + " is hungry.");
        if (table.fork_available(this)) {
            isEating = true;
            isHungry = false; 
            System.out.println(label + " picked up both forks.");
        } else {
            // If not successful, check for deadlock
            checkDeadlock();
        }
    }
    private void eat() throws InterruptedException {
        System.out.println(this.label + " is eating.");
        Thread.sleep(5000); // eating 5 seconds suppose
    }
}
