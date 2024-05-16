import java.util.ArrayList;
import java.util.HashSet;

public class EmployeeDepartment {
    private final String name;
    private ArrayList<Employee> employees = new ArrayList<>();
    private static HashSet<String> names = new HashSet<>();
    private static int counter = 0;
    private final int employeeDepartmentID;

    private EmployeeDepartment(String name) throws NotUniqueNameException {
        if (names.contains(name)) {
            throw new NotUniqueNameException("Name: " + name + " isn't unique");
        }
        this.name = name;
        names.add(name);
        this.employeeDepartmentID = ++counter;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

    public static EmployeeDepartment createDepartment(String name) throws NotUniqueNameException {
        return new EmployeeDepartment(name);
    }

    public String toString() {
        return this.getClass().getName() + "( " + this.getName() + this.getEmployees() + ")";
    }
}