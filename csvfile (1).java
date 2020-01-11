import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class csvfile {
    String firstName;
    String lastName;
    String dateOfBirth;
    String experience;
    static String emp[] = new String[100];
    public ArrayList<Employee> empcsv=new ArrayList<Employee>();




    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getExperience() {
        return experience;
    }


    public ArrayList<Employee> readfile() throws Exception {
        csvfile c = new csvfile();
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader("employee.csv"));
        List<String> lines = new ArrayList<>();
        while ((line = br.readLine()) != null)
        {
            lines.add(line);
        }
        String values[] = new String[100];
        //ArrayList<Employee> empcsv=new ArrayList<Employee>();
        for (int i = 0; i < 100; i++) {
            Employee e=new Employee();
            values = lines.get(i).split(",");
            //System.out.println(Arrays.toString(values));
            ((csvfile) c).setFirstName((String) values[0]);
            ((csvfile) c).setLastName((String) values[1]);
            ((csvfile) c).setDateOfBirth((String) values[2]);
            ((csvfile) c).setExperience(new Double(values[3]).toString());

            e.setFirstName(values[0]);

            e.setLastName(values[1]);


            Date dateOfBirth=new SimpleDateFormat("dd/MM/yyyy").parse(values[2]);
            e.setDateOfBirth(dateOfBirth);

            e.setExperience((Integer.parseInt(values[3])));
            empcsv.add(e);
        }
        return empcsv;



        }

         void write(ArrayList<Employee> a,int writer)throws IOException{
             int count = 0;
             FileWriter outputfile = new FileWriter("example1.csv", true);
             CSVWriter writer1 = new CSVWriter(outputfile);
             String[] header = {"Firstname", "Lastname", "DOB", "Experience"};
             writer1.writeNext(header);

             for (Employee e:a) {
                 if(count < 100) {
                     SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                     String strDate = formatter.format(a.get(writer).getDateOfBirth());
                     String Exp = "" + a.get(writer).getExperience();
                     String[] temp = {a.get(writer).getFirstName(), a.get(writer).getLastName(), strDate, Exp};
                     writer1.writeNext(temp);
                     count++;
                     writer--;
                 }
             }
             try {
                     writer1.close();
                 }catch (Exception e){

                }

            }


    }




