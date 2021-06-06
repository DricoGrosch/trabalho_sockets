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

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public Person create(HashMap<String, String> params) {
        Student s = (Student) super.create(params);
        s.registrationNumber = params.get("registrationNumber");
        return s;
    }

    @Override
    public String toString() {
        String msg = super.toString();
        msg += "registrationNumber='" + registrationNumber + '\'' +
                '}';
        return msg;
    }
}