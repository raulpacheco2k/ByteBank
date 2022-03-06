package br.com.bytebank.HumanResources.Models;

import br.com.bytebank.Bank.Models.Person;
import br.com.bytebank.HumanResources.Interfaces.Bonifiable;

public abstract class Employee extends Person implements Bonifiable<Employee> {

    private Occupation occupation;

    public Employee(Person person, double salary, String profession) {
        super(person.getFull_name(), person.getDocument_cpf());
        this.occupation = new Occupation(salary, profession);
    }

    public String getFull_name() {
        return super.getFull_name();
    }

    public String getDocument_cpf() {
        return super.getDocument_cpf();
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public Employee setOccupation(Occupation occupation) {
        this.occupation = occupation;
        return this;
    }
}