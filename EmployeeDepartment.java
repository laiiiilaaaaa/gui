import java.util.ArrayList;

public class EmployeeDepartment {
    private final int amountED = Main.amountED;
    private String name;
    public final ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeDepartment(String name) {
        try {
            if (Main.occupiedNames.contains(name)) {
                throw new NotUniqueNameException("This name isn't unique");
            }
            this.name = name;
            Main.occupiedNames.add(name);
        } catch (NotUniqueNameException e) {
            e.getStackTrace();
        }
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

    public int getAmountED() {
        return this.amountED;
    }

    public EmployeeDepartment createDepartment(EmployeeDepartment department) {
        Main.amountED++;
        return department;
    }

    public String toString() {
        return this.getClass() + "( " + this.getAmountED() + " " + this.getName() + this.getEmployees() + ")";
    }
}