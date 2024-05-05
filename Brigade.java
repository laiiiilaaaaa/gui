import java.util.ArrayList;

public class Brigade {
    private final int amountB = Main.amountB;
    private final String name;
    private final Foreman foreman;
    public ArrayList<Employee> employees = new ArrayList<>();

    public Brigade(String name, Foreman foreman) {
        this.name = name;
        this.foreman = foreman;
        Main.amountB++;
    }

    public String getName() {
        return this.name;
    }

    public Foreman getForeman() {
        return this.foreman;
    }

    public int getAmountB() {
        return this.amountB;
    }

    public void addEmployee(Employee employee) {
        try {
            if (employee.getClass() == User.class) {
                throw new IllegalArgumentException("Cannot add employee to user");
            }
            this.employees.add(employee);
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }
    }

    public void addEmployee(ArrayList<Employee> employees) {
        try {
            for (Employee employee : employees) {
                if (employee.getClass() == User.class) {
                    throw new IllegalArgumentException("Cannot add employee to user");
                }
                this.employees.add(employee);
            }
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }
    }

    public String toString() {
        return this.getClass() + "( " + this.getAmountB() + " " + this.getName() + " " + this.getForeman() + " "
                + this.employees + " )";
    }
}