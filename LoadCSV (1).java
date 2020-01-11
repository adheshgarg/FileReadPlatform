import java.sql.*;
import java.util.*;
import java.util.Date;

public class LoadCSV{

public void write(Employee employee) throws ClassNotFoundException, SQLException {
       String firstname = employee.firstName;
        String lastname = employee.lastName;
        Date dateofbirth = employee.dateOfBirth;
        String q=""+dateofbirth;
        Integer experience = employee.experience;

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trainingdb", "training", "training");
        Statement statement=connection.createStatement();
        String sql = "INSERT INTO employee2 (firstname, lastname, dob, experience) VALUES ('"+firstname+"','"+lastname+"','"+q+"','"+experience+"');";
        statement.executeUpdate(sql);
        System.out.println("Connected");
            System.out.println("Done");
            statement.close();
            connection.close();
        }
    }