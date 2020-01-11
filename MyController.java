import java.io.IOException;

public class MyController extends Thread{

    public static void main(String[] args) throws IOException {
        Thread[] thread = new Thread[6];
        int[] function={1,2,3,4,5,6};
         for(int i=0;i<3;i++){
             MyThread t = new MyThread(function[i]);
             thread[i]=t;
             thread[i].start();
         }

         for(int i=0;i<3;i++){
             try{
                 thread[i].join();
             }catch (Exception e){

             }
         }
         //System.out.println(MyThread.totalCount);

         for(int i=3;i<6;i++){
             MyThread t= new MyThread(function[i]);
             thread[i]=t;
             thread[i].start();
         }

         for(int i=3;i<6;i++){
             try{
                 thread[i].join();
             }catch (Exception e){

             }
         }
        }
}
