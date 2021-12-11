package HumanResources;

public class Occupation {
    private double salary;
    private String profession;

    public Occupation(double salary, String profession) {
        this.setSalary(salary);
        this.setProfession(profession);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
