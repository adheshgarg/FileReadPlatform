import java.util.Date;

public class Employee{

    public String firstName ;
    public String lastName ;
    public Date dateOfBirth ;
    public int experience ;



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "EOP{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", experience=" + experience +
                '}';
    }
    /*public void read(String s)
    {
        switch(s)
        {
            case "CSVR":
                break;
            case "JSONR":
                break;
            case "XMLR":
                break;
        }
    }

    public void write(String s)
    {
        switch(s)
        {
            case "CSVW":
                break;
            case "JSONW":
                break;
            case "XMLW":
                break;
        }
    }*/


}