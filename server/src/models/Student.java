package models;

import java.io.PrintStream;
import java.util.HashMap;

public class Student extends Person {
    private String registrationNumber;

    public Student() {
    }

    public Student(String name, String cpf, String address, String registrationNumber) {
        super(name, cpf, address);
        this.registrationNumber = registrationNumber;
    }

    @Override
    public BaseModel create(HashMap<String, String> params) {
        Student s = new Student(params.get("name"), params.get("cpf"), params.get("address"), "");
        return s;
    }
}