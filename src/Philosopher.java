public class Philosopher {
    private final Table table;
    private final String label;
    public Philosopher(Table table,String label){
        this.table = table;
        this.label = label;
    }
    public void simulate_philosopher() {
        // try{
        //     System.out.println(this.label + " is thinking on table "+ this.table.getId());
        // }catch(InterruptedException e){
        //     Thread.currentThread().interrupt();
        // }
        System.out.println(this.label + " is thinking on table "+ this.table.getId());
    }
    // private void think() throws InterruptedException{
    //    System.out.println(this.label + " is thinking on table "+ this.table.getId());
    // //    Thread.sleep(1000);    // thinking for bla bla seconds
    // }
}
