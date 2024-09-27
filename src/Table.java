import java.util.concurrent.Semaphore;
public class Table {
   private final Semaphore[] forks = new Semaphore[5];
    private int id;
    public Table(int id){
      this.id = id;
    }
    public int getId(){
      return this.id;
    }
    public boolean fork_available(String philosopherLabel) throws InterruptedException {
          int leftFork = philosopherLabel.charAt(0) % 5;
          int rightFork = (leftFork + 1) % 5;
          if (forks[leftFork].tryAcquire()) {
            try {
                
                if (forks[rightFork].tryAcquire()) {     // trying to get the right fork
                    System.out.println(philosopherLabel + " picked up both forks.");
                    return true;  // when he gets both forks
                } 
            } finally {
                forks[leftFork].release();
            }
        }
        return false; 
  }
}
