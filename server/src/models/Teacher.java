package models;

public class Teacher extends Person {
    private String discipline;

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public Teacher(String name, String cpf, String address, String discipline) {
        super(name, cpf, address);
        this.discipline = discipline;
    }

    public Teacher(String name, String cpf, String address) {
        super(name, cpf, address);
    }
}
