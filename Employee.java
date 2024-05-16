import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Employee implements Comparable<Employee> {
    private static int counter = 0;
    private final int employeeID;
    private static ArrayList<Employee> employees = new ArrayList<>();
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

class Specialist extends Employee {
    private final String specialisation;

    public Specialist(String name, String surname, LocalDateTime dateOfBirth, EmployeeDepartment department,
                      String specialisation) {
        super(name, surname, dateOfBirth, department);
        this.specialisation = specialisation;
    }

    public String getSpecialisation() {
        return this.specialisation;
    }

    @Override
    public String toString() {
        return super.toString() + this.getSpecialisation();
    }
}

class User extends Employee {
    private final String login;
    private final String password;
    private String initial = String.valueOf(this.name.charAt(0) + this.surname.charAt(0));

    public User(String name, String surname, LocalDateTime dateOfBirth, EmployeeDepartment department, String login,
                String password) {
        super(name, surname, dateOfBirth, department);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getInitial() {
        return this.initial;
    }

    private void setInitial() {
        this.initial = String.valueOf(this.name.charAt(0) + this.surname.charAt(0));
    }

    @Override
    public void changeName(String newName) {
        super.changeName(newName);
        setInitial();
    }

    @Override
    public void changeSurname(String newSurname) {
        super.changeSurname(newSurname);
        setInitial();
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.getLogin() + " " + this.getPassword() + " " + this.getInitial();
    }
}

class Foreman extends User {
    private ArrayList<Brigade> brigades = new ArrayList<>();
    private ArrayList<Commission> commissions = new ArrayList<>();

    public Foreman(String name, String surname, LocalDateTime dateOfBirth, EmployeeDepartment department, String login,
                   String password) {
        super(name, surname, dateOfBirth, department, login, password);
    }

    public ArrayList<Commission> getCommissions() {
        return this.commissions;
    }

    public ArrayList<Brigade> getBrigades() {
        return this.brigades;
    }

    public void addCommission(Commission commission) {
        this.commissions.add(commission);
    }

    public void addBrigade(Brigade brigade) {
        this.brigades.add(brigade);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}