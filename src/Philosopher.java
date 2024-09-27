public class Philosopher {
    private final Table table;
    private final String label;
    public Philosopher(Table table,String label){
        this.table = table;
        this.label = label;
    }
    public void simulate_philosopher() {
        while (true) {
        try{
            think();
            if(table.fork_available(this.label)){
                eat();
            }
            else{
                //check deadlock
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
     }
    }
    private void think() throws InterruptedException{
       System.out.println(this.label + " is thinking on table "+ this.table.getId());
       Thread.sleep(1000);    // thinking for bla bla seconds
    }
    private void eat() throws InterruptedException {
        System.out.println(this.label + " is eating.");
        Thread.sleep(5000); // eating 5 seconds suppose
    }
}
