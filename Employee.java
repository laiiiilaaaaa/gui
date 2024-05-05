import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Employee {
    private final int amountE = Main.amountE;
    public static ArrayList<Employee> employees = new ArrayList<>();
    private String name;
    private String surname;
    private final LocalDateTime dateOfBirth;
    private final EmployeeDepartment department;

    public Employee(String name, String surname, LocalDateTime dateOfBirth, EmployeeDepartment department) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        Main.amountE++;
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

    public int getAmountE() {
        return this.amountE;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    interface Comparable {
        int compareTo(Employee employee);
    }

    public int compareTo(Employee employee) {
        return this.getName().compareTo(employee.getName()) != 0 ? this.getName().compareTo(employee.getName()) :
                this.getName().compareTo(employee.getDateOfBirth().toString());
    }

    public String toString() {
        return this.getClass() + "( " + this.getAmountE() + " " + employees + " " + this.getName() + " "
                + this.getSurname() + " " + this.getDateOfBirth() + " " + this.getDepartment() + ")";
    }
}

class Specialist extends Employee implements Comparable {
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
    public int compareTo(Employee employee) {
        return super.compareTo(employee);
    }

    @Override
    public String toString() {
        return super.toString() + this.getSpecialisation();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class User extends Employee implements Comparable {
    private final String login;
    private final String password;
    private String initial = String.valueOf(super.getName().charAt(0) + super.getSurname().charAt(0));

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

    @Override
    public int compareTo(Employee employee) {
        return super.compareTo(employee);
    }

    public String getInitial() {
        return this.initial;
    }

    public String modifyInitial(String name, String surname) {
        if (!super.getName().equals(name) || !super.getSurname().equals(surname)) {
            this.initial = String.valueOf(super.getName().charAt(0) + super.getSurname().charAt(0));
            super.setName(name);
            super.setSurname(surname);
        }
        return this.initial;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.getLogin() + " " + this.getPassword() + " " + this.getInitial();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Foreman extends User implements Comparable {
    private final HashMap<Brigade, Commission> commissions = new HashMap<>();

    public Foreman(String name, String surname, LocalDateTime dateOfBirth, EmployeeDepartment department, String login,
                   String password) {
        super(name, surname, dateOfBirth, department, login, password);
    }

    @Override
    public int compareTo(Employee employee) {
        return super.compareTo(employee);
    }

    public HashMap<Brigade, Commission> getCommissions() {
        return this.commissions;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}