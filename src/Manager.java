public class Manager extends Employee {

    private int password;

    public boolean authentication(int password) {
        return this.password == password;
    }

    public double bonus() {
        return this.getSalary();
    }
}
