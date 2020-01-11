import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MyFileHandler {
    Employee read(int a);
    void write(Employee e, int i) throws UnknownHostException, SQLException, ClassNotFoundException;
}
