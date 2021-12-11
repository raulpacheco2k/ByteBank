package HumanResources;

import Bank.Person;

public abstract class Employee extends Person {

    String profession;
    private double salary;
    private double bonus = 0.05;

    public Employee(String full_name, String document_cpf) {
        super(full_name, document_cpf);
    }

    public abstract double calculateBonus();

    public String getFull_name() {
        return super.getFull_name();
    }

    public void setFull_name(String full_name) {
        super.setFull_name(full_name);
    }

    public String getDocument_cpf() {
        return super.getDocument_cpf();
    }

    public void setDocument_cpf(String document_cpf) {
        super.setDocument_cpf(document_cpf);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
