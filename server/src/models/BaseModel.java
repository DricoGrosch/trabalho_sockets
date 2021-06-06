package models;

import java.io.PrintStream;
import java.util.HashMap;

public class BaseModel {
    static final String CREATE = "create";
    static final String UPDATE = "update";
    static final String DELETE = "delete";
    static final String GETONE = "getone";
    static final String GETALL = "getall";

    public BaseModel create(HashMap<String, String> params) {
        return null;
    }

    public void update(HashMap<String, String> params, PrintStream ps) {

    }

    public void delete(HashMap<String, String> params, PrintStream ps) {
    }

    public static void getAll(HashMap<String, String> params, PrintStream ps) {

    }

    public BaseModel dispatchOperation(HashMap<String, String> params, PrintStream ps) {
        return null;
    }
}
