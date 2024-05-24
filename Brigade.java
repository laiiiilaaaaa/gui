import java.util.ArrayList;
import java.util.HashSet;

public class Brigade {
    private static int counter = 0;
    private final int brigadeID;
    private final String name;
    private final Foreman foreman;
    private final HashSet<Employee> employees = new HashSet<>();

    public Brigade(String name, Foreman foreman) {
        this.name = name;
        this.foreman = foreman;
        brigadeID = ++counter;
    }

    public String getName() {
        return this.name;
    }

    public Foreman getForeman() {
        return this.foreman;
    }

    public HashSet<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        if (employee instanceof User) {
            throw new IllegalArgumentException("Cannot add user to employee list");
        }
        employees.add(employee);
    }

    public void addEmployee(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            addEmployee(employee);
        }
    }

    public String toString() {
        return this.getClass().getName() + "( " + this.name + " " + this.foreman + " " + employees + " )";
    }
}