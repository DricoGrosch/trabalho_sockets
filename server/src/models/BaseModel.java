package models;

import java.io.PrintStream;
import java.util.HashMap;

public class BaseModel {
    public final String CREATE = "create";
    public final String UPDATE = "update";
    public final String DELETE = "delete";
    public final String GETONE = "getone";
    public final String GETALL = "getall";

    public BaseModel create(HashMap<String, String> params,PrintStream ps) {
        return null;
    }

    public BaseModel update(HashMap<String, String> params,PrintStream ps) {
        return null;
    }

    public boolean delete(HashMap<String, String> params,PrintStream ps) {
        return true;
    }

    public BaseModel getOne(HashMap<String, String> params,PrintStream ps) {
        return null;
    }

    public BaseModel[] getAll(HashMap<String, String> params,PrintStream ps  ) {
        return null;
    }

    public void dispatchOperation(HashMap<String, String> params, PrintStream ps) {
        switch (params.get("operation")) {
            case CREATE: {
                this.create(params,ps);
            }
            case UPDATE: {
                this.update(params,ps);
            }
            case DELETE: {
                this.delete(params,ps);
            }
            case GETONE: {
                this.getOne(params,ps);
            }
            default: {
                this.getAll(params,ps);
            }
        }
    }
}
