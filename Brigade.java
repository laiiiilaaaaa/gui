import java.util.ArrayList;

public class Brigade {
    private static int counter = 0;
    private final int brigadeID;
    private final String name;
    private final Foreman foreman;
    private static ArrayList<Employee> employees = new ArrayList<>();

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

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        if (employee.getClass() == User.class) {
            throw new IllegalArgumentException("Cannot add employee to user");
        }
        employees.add(employee);
    }

    public void addEmployee(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            if (employee.getClass() == User.class) {
                throw new IllegalArgumentException("Cannot add employee to user");
            }
            employees.add(employee);
        }
    }

    public String toString() {
        return this.getClass().getName() + "( " + this.name + " " + this.foreman + " " + employees + " )";
    }
}