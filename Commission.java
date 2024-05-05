import java.time.LocalDateTime;
import java.util.HashSet;

enum Type {
    PLANNED,
    NOT_PLANNED
}

enum State {
    CREATED,
    STARTED,
    state, ENDED
}

public class Commission {
    public HashSet<Job> jobs = new HashSet<>();
    private Brigade brigade;
    private final Type type;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfStart;
    private LocalDateTime dateOfEnd;
    public State state;

    public Commission(boolean isPlanned) {
        this.type = isPlanned ? Type.PLANNED : Type.NOT_PLANNED;
    }

    public Commission(boolean isPlanned, Brigade brigade) {
        this.type = isPlanned ? Type.PLANNED : Type.NOT_PLANNED;
        this.brigade = brigade;
    }

    public Commission(boolean isPlanned, HashSet<Job> jobs) {
        this.type = isPlanned ? Type.PLANNED : Type.NOT_PLANNED;
        this.jobs = jobs;
    }

    public Commission(boolean isPlanned, HashSet<Job> jobs, Brigade brigade) {
        this.type = isPlanned ? Type.PLANNED : Type.NOT_PLANNED;
        this.jobs = jobs;
        this.brigade = brigade;
    }

    interface Runnable {
        void run();
    }

    public Brigade getBrigade() {
        return this.brigade;
    }

    public Type getType() {
        return this.type;
    }

    public LocalDateTime getDateOfCreation() {
        return this.dateOfCreation;
    }

    public LocalDateTime getDateOfStart() {
        return this.dateOfStart;
    }

    public LocalDateTime getDateOfEnd() {
        return this.dateOfEnd;
    }

    public void addJob(Job job) {
        this.jobs.add(job);
    }

    public void addJob(HashSet<Job> jobs) {
        this.jobs.addAll(jobs);
    }

    public boolean addBrigade(Brigade brigade) {
        this.brigade = brigade;
        return this.brigade != null;
    }

    public void run() {
        try {
            for (Employee employee : this.brigade.employees) {
                int amount = 0;
                for (Employee e : employee.getDepartment().getEmployees()) {
                    if (e == employee) {
                        amount++;
                    }
                }
                if (amount > 1) {
                    throw new IllegalStateException();
                }
            }
            if (this.addBrigade(this.brigade) && !this.jobs.isEmpty()) {
                this.dateOfCreation = LocalDateTime.now();
                this.state = State.CREATED;
                this.dateOfStart = LocalDateTime.now();
                this.state = State.STARTED;
                for (Job job : this.jobs) {
                    job.start();
                    if (this.getState()) {
                        System.out.println(job.getState());
                    }
                }
                this.dateOfEnd = LocalDateTime.now();
                this.state = State.ENDED;
            }
        } catch (IllegalStateException e) {
            e.getStackTrace();
        }
    }

    public boolean getState() {
        return true;
    }

    public static void addCommission(Commission commission) {
        Main.commissions.put(Main.amountC, commission);
        Main.amountC++;
    }

    public String toString() {
        return this.getClass() + "( " + this.jobs + " " + this.getBrigade() + " " + this.getType() + " " +
                this.getDateOfCreation() + " " + this.getDateOfStart() + " " + this.getDateOfEnd() + " " + this.getState() + " )";
    }
}