import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Employee implements Comparable<Employee> {
    private static int counter = 0;
    private final int employeeID;
    private static final ArrayList<Employee> employees = new ArrayList<>();
    protected String name;
    protected String surname;
    private final LocalDateTime dateOfBirth;
    private final EmployeeDepartment department;

    public Employee(String name, String surname, LocalDateTime dateOfBirth, EmployeeDepartment department) {
        this.employeeID = ++counter;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        employees.add(this);
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public LocalDateTime getDateOfBirth() {
        return this.dateOfBirth;
    }

    public EmployeeDepartment getDepartment() {
        return this.department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int compareTo(Employee employee) {
        return (this.name.length() == employee.name.length() && this.name.equals(employee.name)
                && this.dateOfBirth.equals(employee.dateOfBirth)) ? 0 : 1;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void changeSurname(String newSurname) {
        this.surname = newSurname;
    }

    public String toString() {
        return this.getClass() + "( " + employees + " " + this.getName() + " "
                + this.getSurname() + " " + this.getDateOfBirth() + " " + this.getDepartment() + ")";
    }
}