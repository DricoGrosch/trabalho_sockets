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

    public static Student createFromQueryString(String query) {
        String[] params = query.split(";");
        String cpf = params[2].split("=")[1];
        String name = params[3].split("=")[1];
        String address = params[4].split("=")[1];
        return new Student(cpf, name, address);
    }
}