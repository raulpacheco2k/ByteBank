package HumanResources;

public class Employee {

    private String full_name;
    private String document_cpf;
    private double salary;
    private double bonus = 0.05;

    public double calculateBonus() {
        return this.getSalary() * this.bonus;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDocument_cpf() {
        return document_cpf;
    }

    public void setDocument_cpf(String document_cpf) {
        this.document_cpf = document_cpf;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
