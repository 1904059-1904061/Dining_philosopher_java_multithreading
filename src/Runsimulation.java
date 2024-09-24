import java.io.*; 
import java.util.*; 
public class Runsimulation {
    private int num_tables;
    private int philosophers_per_table;
    // private String[] philsopher_label = new String[25];
    public Runsimulation(){
        this.num_tables = 5;
        this.philosophers_per_table = 5;
    }
    public void startSimulation(){
    Table[] tables = new Table[num_tables+1];
    for (int i=1;i<=num_tables;i++){
        tables[i] = new Table(i);
    }
    for(int i = 1;i<=5;i++){
        for(int j=1;j<=5;j++){
           String philsopher_label =Character.toString((char)65);
        }
    }
  }
   
}
