import java.time.LocalDateTime;

public class Specialist extends Employee {
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