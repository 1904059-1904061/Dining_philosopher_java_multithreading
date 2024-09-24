public class App {
    public static void main(String[] args) throws Exception {
       int num_tables = 5;
       Table[] tables = new Table[num_tables+1];
       for (int i=1;i<=num_tables;i++){
        tables[i] = new Table(i);
       }
       
    }
}
