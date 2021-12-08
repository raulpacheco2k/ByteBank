package HumanResources;

public class Manager extends Employee {

    private int password;
    private double bonus = 0.1;

    public boolean authentication(int password) {
        return this.password == password;
    }

    @Override
    public double calculateBonus() {
        return super.getSalary() * this.bonus;
    }
}
