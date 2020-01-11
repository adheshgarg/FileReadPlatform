import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JSONReadWrite implements ReaderWriter {
    int count = 0;
    public ArrayList<Employee> array = new ArrayList();


    @Override
    public void write(ArrayList<Employee> arrayList,int writer) throws Exception {
        JSONObject jo = new JSONObject();

        JSONArray joarray = new JSONArray();


        PrintWriter pw = new PrintWriter("newemployee.json");

        for (Employee o : arrayList) {
            if (count < 100) {

                jo.put("firstName", arrayList.get(writer).getFirstName());
                jo.put("lastName", arrayList.get(writer).getLastName());
                jo.put("dateOfBirth", arrayList.get(writer).getDateOfBirth());
                jo.put("experience", arrayList.get(writer).getExperience());

                //joarray.add(jo);
                pw.append(jo.toJSONString());
                count++;
                writer--;
            }
        }
        //pw.write(joarray.toJSONString());

        pw.close();
    }

    @Override
    public ArrayList<Employee> read() throws RuntimeException {
        try{
        Object obj = new JSONParser().parse(new FileReader("employee.json"));

        JSONArray jo = (JSONArray) obj;

        for (int i = 0; i < 100; i++) {
            Employee emp = new Employee();


            JSONObject data = (JSONObject) jo.get(i);
            String firstName = (String) data.get("firstName");

            String lastName = (String) data.get("lastName");

            String dateOfBirth = (String) data.get("dateOfBirth");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy");

            long experience = (long) data.get("experience");
            Date date = simpleDateFormat.parse(dateOfBirth);
            String fname = (String) data.get("firstName");
            emp.setFirstName(fname);
            //System.out.println(h);
            String lname = (String) data.get("lastName");
            emp.setLastName(lname);
            //Date dob = (Date) data.get("dateOfBirth");
            emp.setDateOfBirth(date);
            long exp = (long) data.get("experience");
            emp.setExperience((int) exp);

            //System.out.println(emp+"JSON");
            array.add(emp);
        }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return array;
    }

}