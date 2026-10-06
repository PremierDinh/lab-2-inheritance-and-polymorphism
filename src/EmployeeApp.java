import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeApp {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        readEmployeesFromFile(employees);

        if (employees.isEmpty()) {
            System.out.println("No employee data was loaded.");
            return;
        }

        System.out.println("The average pay for all employees is: "
                + getAveragePay(employees));

        System.out.println("The Wages employee with the highest pay is: "
                + getHighestPaidWagesEmployee(employees));

        System.out.println("The Salaried employee with the lowest pay is: "
                + getLowestPaidSalariedEmployee(employees));

        System.out.println("Percentage of Salaried employees is: "
                + getSalariedPercentage(employees) + "%");

        System.out.println("Percentage of Wages employees is: "
                + getWagesPercentage(employees) + "%");

        System.out.println("Percentage of Part Time employees is: "
                + getPartTimePercentage(employees) + "%");
    }

    public static void readEmployeesFromFile(ArrayList<Employee> employees) {

        File file = new File("res/employees.txt");

        try (Scanner input = new Scanner(file)) {

            while (input.hasNextLine()) {

                String line = input.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] data = line.split(":");

                String id = data[0].trim();
                String name = data[1].trim();
                String address = data[2].trim();
                String phone = data[3].trim();
                String sin = data[4].trim();
                String dob = data[5].trim();
                String dept = data[6].trim();

                char firstIdDigit = id.charAt(0);

                if (firstIdDigit >= '0' && firstIdDigit <= '4') {

                    double salary = Double.parseDouble(data[7].trim());

                    employees.add(new Salaried(
                            id, name, address, phone,
                            sin, dob, dept, salary
                    ));

                } else if (firstIdDigit >= '5' && firstIdDigit <= '7') {

                    double rate = Double.parseDouble(data[7].trim());
                    double hours = Double.parseDouble(data[8].trim());

                    employees.add(new Wages(
                            id, name, address, phone,
                            sin, dob, dept, rate, hours
                    ));

                } else if (firstIdDigit >= '8' && firstIdDigit <= '9') {

                    double rate = Double.parseDouble(data[7].trim());
                    double hours = Double.parseDouble(data[8].trim());

                    employees.add(new PartTime(
                            id, name, address, phone,
                            sin, dob, dept, rate, hours
                    ));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file: res/employees.txt");
        } catch (NumberFormatException e) {
            System.out.println("Error: invalid number in employees.txt");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: invalid data format in employees.txt");
        }
    }

    public static double getAveragePay(ArrayList<Employee> employees) {

        double totalPay = 0;

        for (Employee employee : employees) {
            totalPay += employee.getPay();
        }

        return totalPay / employees.size();
    }

    public static String getHighestPaidWagesEmployee(
            ArrayList<Employee> employees) {

        double highestPay = -1;
        String highestPaidName = "";

        for (Employee employee : employees) {

            if (employee instanceof Wages &&
                    employee.getPay() > highestPay) {

                highestPay = employee.getPay();
                highestPaidName = employee.getName();
            }
        }

        return highestPaidName;
    }

    public static String getLowestPaidSalariedEmployee(
            ArrayList<Employee> employees) {

        double lowestPay = Double.MAX_VALUE;
        String lowestPaidName = "";

        for (Employee employee : employees) {

            if (employee instanceof Salaried &&
                    employee.getPay() < lowestPay) {

                lowestPay = employee.getPay();
                lowestPaidName = employee.getName();
            }
        }

        return lowestPaidName;
    }

    public static double getSalariedPercentage(
            ArrayList<Employee> employees) {

        int salariedCount = 0;

        for (Employee employee : employees) {
            if (employee instanceof Salaried) {
                salariedCount++;
            }
        }

        return (double) salariedCount / employees.size() * 100;
    }

    public static double getWagesPercentage(
            ArrayList<Employee> employees) {

        int wagesCount = 0;

        for (Employee employee : employees) {
            if (employee instanceof Wages) {
                wagesCount++;
            }
        }

        return (double) wagesCount / employees.size() * 100;
    }

    public static double getPartTimePercentage(
            ArrayList<Employee> employees) {

        int partTimeCount = 0;

        for (Employee employee : employees) {
            if (employee instanceof PartTime) {
                partTimeCount++;
            }
        }

        return (double) partTimeCount / employees.size() * 100;
    }
}