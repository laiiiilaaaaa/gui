import java.time.LocalDateTime;

public class User extends Employee {
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
