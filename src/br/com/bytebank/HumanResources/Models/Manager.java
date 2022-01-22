package br.com.bytebank.HumanResources.Models;

import br.com.bytebank.InternalSystem.Interfaces.Authenticable;

public class Manager extends Employee implements Authenticable {

    private int password;

    public Manager(String full_name, String document_cpf) {
        super(full_name, document_cpf);
    }

    public boolean authentication(int password) {
        return this.password == password;
    }

    @Override
    public double calculateBonus(double bonus) {
        return super.getSalary() * bonus;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }
}
