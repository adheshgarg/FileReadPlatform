import com.mongodb.*;
import java.util.*;
import java.net.UnknownHostException;


public class MongoWrite {


        public void writeIntoMongo1(Employee e) throws UnknownHostException {
            MongoClient mongo = new MongoClient();
            DB db=mongo.getDB("training");
            DBCollection col = db.getCollection("assignment1");
            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("firstName",e.getFirstName());
            newDocument.put("lastName",e.getLastName());
            newDocument.put("dateOfBirth",e.getDateOfBirth());
            newDocument.put("experience",e.getExperience());
            col.insert(newDocument);
            mongo.close();

    }
}
