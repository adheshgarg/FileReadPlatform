import java.net.UnknownHostException;
import java.sql.SQLException;

public class MyThread extends Thread{
    private int a;

    int arr[];
    static int totalCount=-1;
    static int XMLCounter=0;
    static int CSVCounter=0;
    static int JSONCounter=0;

    static MyCollection myCollection = new MyCollection();
    public MyThread(int a) {

        this.a=a;
        this.arr = new int[6];
    }
    @Override
    public void run() {
        super.run();
        if(a<4){

            ReadFromSources rd = null;
            try {
                rd = new ReadFromSources();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int c1=0;
            while(c1<100) {
                Employee rt=rd.read(a);
                String qw=rt.firstName;

                System.out.println(qw);
                if(!myCollection.list.contains(rt)){
                myCollection.list.add(rt);
                totalCount++;}
            c1++;}


            }
            else{
           int c=100;
            ReadFromSources rd = null;
            try {
                rd = new ReadFromSources();
            } catch (Exception e) {
                e.printStackTrace();
            }
           while(c>0){

               try {
                   rd.write(myCollection.list.get(totalCount),a);
               } catch (UnknownHostException e) {
                   e.printStackTrace();
               } catch (SQLException e) {
                   e.printStackTrace();
               } catch (ClassNotFoundException e) {
                   e.printStackTrace();
               }
               totalCount--;
               c--;
           }
        }


    }

}
