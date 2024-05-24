import java.time.LocalDateTime;
import java.util.ArrayList;

public class Foreman extends User {
    private final ArrayList<Brigade> brigades = new ArrayList<>();
    private final ArrayList<Commission> commissions = new ArrayList<>();

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