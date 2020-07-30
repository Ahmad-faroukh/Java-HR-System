package Controller;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public interface Operators {
    public static String GREATER_THAN = "gt";
    public static String GREATER_THAN_OR_EQUAL = "gte";
    public static String LESS_THAN = "lt";
    public static String LESS_THAN_OR_EQUAL = "lte";
    public static String EQUAL = "eq";
    public static String NOT_EQUAL = "ne";
    
    
    static final String IP = "localhost";
    static final int PORT = 27017;
    static final String DB_NAME = "HR";
    MongoClient client = new MongoClient(Operators.IP,Operators.PORT);
    MongoDatabase database = client.getDatabase(Operators.DB_NAME);
    static MongoCollection<Document> emp = database.getCollection("employee");;
    static MongoCollection<Document> manager = database.getCollection("manager");;
}