import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadFromSources implements MyFileHandler {

    XMLRead xmlRead;
    JSONReadWrite jsonReadWrite;
    csvfile csvfileRead;
    MongoWrite mongoWrite;
    LoadCSV loadCSV;

    ReadFromSources() throws Exception {
        xmlRead=new XMLRead();
        xmlRead.readXml();
        jsonReadWrite=new JSONReadWrite();
        jsonReadWrite.read();
        csvfileRead=new csvfile();
        csvfileRead.readfile();
        mongoWrite=new MongoWrite();
        loadCSV=new LoadCSV();
    }


        public Employee read(int a){


        Employee emp=new Employee();
        if(a==1){
                  if(MyThread.XMLCounter<100)
                  {emp=xmlRead.aremp.get(MyThread.XMLCounter);
                  xmlRead.aremp.remove(emp);
                  MyThread.XMLCounter++;}
            }
         else if(a==2){
                   if(MyThread.JSONCounter<100){
                  emp=jsonReadWrite.array.get(MyThread.JSONCounter);
                  MyThread.JSONCounter++;}
        }
         else if(a==3){
            if(MyThread.CSVCounter<100){
            emp=csvfileRead.empcsv.get(MyThread.CSVCounter);
            MyThread.CSVCounter++;}
        }
           return emp;

    }


    public void write(Employee e,int a) throws UnknownHostException, SQLException, ClassNotFoundException {
            if(a==4 || a==5){
                    mongoWrite.writeIntoMongo1(e);
            }
            else{
                loadCSV.write(e);
            }
    }
}
