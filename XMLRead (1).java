import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class XMLRead
{

    private static String firstName;
    private static String lastName;
    private static Date  dateOfBirth;
    private static int experience;

    private static int count=0;
    public static ArrayList<Employee> aremp=new ArrayList<Employee>();


    public ArrayList<Employee> readXml()
    {

        try
        {

            File file = new File("employee.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("employee");
            int arraylen=nodeList.getLength();

            //aremp=new ArrayList<Employee>();
            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Employee employee = new Employee();
                    Element eElement = (Element) node;
                    firstName = eElement.getElementsByTagName("firstName").item(0).getTextContent();
                    employee.setFirstName(firstName);
                    lastName = eElement.getElementsByTagName("lastName").item(0).getTextContent();
                    employee.setLastName(lastName);
                    String q = eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent();
                    dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(q);
                    employee.setDateOfBirth(dateOfBirth);
                    experience = Integer.parseInt(eElement.getElementsByTagName("experience").item(0).getTextContent());
                    employee.setExperience(experience);
                    aremp.add(employee);
                }

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return aremp;
    }


    public void writeXML(ArrayList<Employee> emp,int writer){


            try{
                FileWriter fw=new FileWriter("newemployee.xml");
                fw.write("<employees>");


                for (Employee emp1:emp
                     ) {
                     if(count < 100){

                    fw.write("<employee>");
                    fw.write("<firstName>" + emp.get(writer).getFirstName() + "</firstName>");
                    fw.write("<lastName>" + emp.get(writer).getLastName() + "</firstName>");
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                    String strDate = formatter.format(emp.get(writer).getDateOfBirth());

                    fw.write("<dateOfBirth>" + strDate + "</dateOfBirth>");
                    fw.write("<experience>" + emp.get(writer).getFirstName() + "</experience>");
                    fw.write("</employee>");
                    fw.write("\n");

                    //MyCollection.list.remove(MyCollection.readCounter);
                    //MyCollection.readCounter++;
                    count++;
                    writer--;

                     }
                }
                fw.close();
            }catch(Exception e){//System.out.println(e);
                //
                }
            //System.out.println("Success...");


    }












}
