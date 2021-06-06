package models;

public class Student extends Person {
    private String registrationNumber;

    public Student() {
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Student(String name, String cpf, String address, String registrationNumber) {
        super(name, cpf, address);
        this.registrationNumber = registrationNumber;
    }

    public Student(String name, String cpf, String address) {
        super(name, cpf, address);
    }

}