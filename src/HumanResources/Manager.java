package HumanResources;

import InternalSystem.Authenticable;

public class Manager extends Employee implements Authenticable {

    private int password;
    private double bonus = 0.1;

    public Manager(String full_name, String document_cpf) {
        super(full_name, document_cpf);
    }

    public boolean authentication(int password) {
        return this.password == password;
    }

    @Override
    public double calculateBonus() {
        return super.getSalary() * this.bonus;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }
}
