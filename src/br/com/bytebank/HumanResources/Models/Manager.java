package br.com.bytebank.HumanResources.Models;

import br.com.bytebank.Bank.Models.Person;
import br.com.bytebank.InternalSystem.Interfaces.Authenticable;

public class Manager extends Employee implements Authenticable {

    private int password;

    public Manager(Person person, double salary, String profession) {
        super(person, salary, profession);
    }

    public boolean authentication(int password) {
        return this.password == password;
    }

    @Override
    public Employee setBonus() {
        return null;
    }

    @Override
    public double getBonus() {
        return 0;
    }

    @Override
    public double calculateBonus(double bonus) {
        return super.getOccupation().getSalary() * bonus;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }
}
