import java.util.ArrayList;

public interface ReaderWriter {
    public void write(ArrayList<Employee> arrayList, int writer) throws Exception;
    public ArrayList<Employee> read() throws Exception;
}
