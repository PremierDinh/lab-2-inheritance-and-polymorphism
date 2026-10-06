public class Salaried extends Employee {

    private double salary;

    public Salaried() {
    }

    public Salaried(String id, String name, String address,
                    String phone, String sin, String dob,
                    String dept, double salary) {

        super(id, name, address, phone, sin, dob, dept);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getPay() {
        return salary / 52.0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEmployee Type: Salaried" +
                "\nYearly Salary: " + salary +
                "\nWeekly Pay: " + getPay();
    }
}