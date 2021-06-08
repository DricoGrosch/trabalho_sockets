package models;

import javax.xml.crypto.Data;

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
    public String toString() {
        String msg = super.toString();
        msg += ";registrationNumber='" + registrationNumber+" | ";
        return msg;
    }
}