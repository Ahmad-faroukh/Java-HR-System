package Controller;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import Model.Employee;
import Model.Manager;
import com.google.gson.GsonBuilder;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

public class Methods {

    public static void addEmployee(Employee emp) {
        Operators.emp.insertOne(new Document("empId", emp.getEmpId())
                .append("name", emp.getName())
                .append("password", emp.getPassword())
                .append("gender", emp.getGender())
                .append("phone", emp.getPhone())
                .append("email", emp.getEmail())
                .append("salary", emp.getSalary())
                .append("department", emp.getDepartment())
                .append("address", emp.getAddress())
                .append("onHoliday", emp.isOnHoliday())
        );
    }

    public static void addManager(Manager manager) {
        Operators.manager.insertOne(new Document("name", manager.getName())
                .append("password", manager.getPassword())
        );
    }

    public static List<Employee> searchEmployee(String operator, String key, Object value) {
        List<Employee> list = new ArrayList<>();
        MongoCollection<Document> collection = Operators.emp;
        FindIterable<Document> iterator = null;;
        switch (operator) {
            case Operators.EQUAL:
                iterator = collection.find(Filters.eq(key, value));
                break;
            case Operators.GREATER_THAN:
                iterator = collection.find(Filters.gt(key, value));
                break;
            case Operators.GREATER_THAN_OR_EQUAL:
                iterator = collection.find(Filters.gte(key, value));
                break;
            case Operators.LESS_THAN:
                iterator = collection.find(Filters.lt(key, value));
                break;
            case Operators.LESS_THAN_OR_EQUAL:
                iterator = collection.find(Filters.lte(key, value));
                break;
            case Operators.NOT_EQUAL:
                iterator = collection.find(Filters.ne(key, value));
                break;
            default:
                System.out.println("Wrong Operator!!");
                return null;
        }

        for (Document doc : iterator) {
            list.add(new GsonBuilder().create().fromJson(doc.toJson(), Employee.class));
        }

        return list;
    }

    public static List<Manager> searchManager(String operator, String key, Object value) {
        List<Manager> list = new ArrayList<>();
        MongoCollection<Document> collection = Operators.manager;
        FindIterable<Document> iterator = null;;
        switch (operator) {
            case Operators.EQUAL:
                iterator = collection.find(Filters.eq(key, value));
                break;
            case Operators.GREATER_THAN:
                iterator = collection.find(Filters.gt(key, value));
                break;
            case Operators.GREATER_THAN_OR_EQUAL:
                iterator = collection.find(Filters.gte(key, value));
                break;
            case Operators.LESS_THAN:
                iterator = collection.find(Filters.lt(key, value));
                break;
            case Operators.LESS_THAN_OR_EQUAL:
                iterator = collection.find(Filters.lte(key, value));
                break;
            case Operators.NOT_EQUAL:
                iterator = collection.find(Filters.ne(key, value));
                break;
            default:
                System.out.println("Wrong Operator!!");
                return null;
        }

        for (Document doc : iterator) {
            list.add(new GsonBuilder().create().fromJson(doc.toJson(), Manager.class));
        }

        return list;
    }

    public static long updateEmployee(String operator, String searchKey, Object searchValue, String updateKey, Object updateValue) {
        MongoCollection<Document> coll = Operators.emp;
        Document doc = new Document("$set", new Document(updateKey, updateValue));
        UpdateResult result = null;
        switch (operator) {
            case Operators.EQUAL:
                result = coll.updateMany(Filters.eq(searchKey, searchValue), doc);
                break;
            case Operators.GREATER_THAN:
                result = coll.updateMany(Filters.gt(searchKey, searchValue), doc);
                break;
            case Operators.GREATER_THAN_OR_EQUAL:
                result = coll.updateMany(Filters.gte(searchKey, searchValue), doc);
                break;
            case Operators.LESS_THAN:
                result = coll.updateMany(Filters.lt(searchKey, searchValue), doc);
                break;
            case Operators.LESS_THAN_OR_EQUAL:
                result = coll.updateMany(Filters.lte(searchKey, searchValue), doc);
                break;
            case Operators.NOT_EQUAL:
                result = coll.updateMany(Filters.ne(searchKey, searchValue), doc);
                break;
            default:
                System.out.println("Wrong Operator!!");
                return -1;
        }
        return result.getModifiedCount();
    }

    public static long deleteEmployee(String operator, String key, Object value) {
        MongoCollection<Document> coll = Operators.emp;
        DeleteResult result = null;
        switch (operator) {
            case Operators.EQUAL:
                result = coll.deleteMany(Filters.eq(key, value));
                break;
            case Operators.GREATER_THAN:
                result = coll.deleteMany(Filters.gt(key, value));
                break;
            case Operators.GREATER_THAN_OR_EQUAL:
                result = coll.deleteMany(Filters.gte(key, value));
                break;
            case Operators.LESS_THAN:
                result = coll.deleteMany(Filters.lt(key, value));
                break;
            case Operators.LESS_THAN_OR_EQUAL:
                result = coll.deleteMany(Filters.lte(key, value));
                break;
            case Operators.NOT_EQUAL:
                result = coll.deleteMany(Filters.ne(key, value));
                break;
            default:
                System.out.println("Wrong Operator!!");
                return -1;
        }
        return result.getDeletedCount();
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        MongoCollection<Document> collection = Operators.emp;
        for (Document doc : collection.find()) {
            list.add(new GsonBuilder().create()
                    .fromJson(doc.toJson(), Employee.class));
        }
        return list;
    }

}
