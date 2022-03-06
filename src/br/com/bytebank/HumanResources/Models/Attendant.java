package br.com.bytebank.HumanResources.Models;

import br.com.bytebank.Bank.Models.Person;

public class Attendant extends Employee {

    public Attendant(Person person, double salary, String profession) {
        super(person, salary, profession);
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
        return 0;
    }
}
