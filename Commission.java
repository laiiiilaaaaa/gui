import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

enum Type {
    PLANNED,
    NOT_PLANNED
}

public class Commission implements Runnable {
    private static int counter = 0;
    private final int commissionId;
    private ArrayList<Job> jobs = new ArrayList<>();
    private Brigade brigade;
    private final Type type;
    private final LocalDateTime dateOfCreation;
    private LocalDateTime dateOfStart = null;
    private LocalDateTime dateOfEnd = null;
    private State state;
    private static final HashSet<Commission> currentCommissions = new HashSet<>();
    private static final HashMap<Integer, Commission> commissions = new HashMap<>();

    public Commission(boolean isPlanned) {
        this(isPlanned, null, null);
    }

    public Commission(boolean isPlanned, Brigade brigade) {
        this(isPlanned, null, brigade);
    }

    public Commission(boolean isPlanned, ArrayList<Job> jobs) {
        this(isPlanned, jobs, null);
    }

    public Commission(boolean isPlanned, ArrayList<Job> jobs, Brigade brigade) {
        this.type = isPlanned ? Type.PLANNED : Type.NOT_PLANNED;
        this.jobs = jobs;
        this.commissionId = ++counter;
        this.state = State.CREATED;
        this.dateOfCreation = LocalDateTime.now();
        this.addBrigade(brigade);
        commissions.put(this.commissionId, this);
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
        if (this.brigade == null) {
            this.brigade = brigade;
            this.brigade.getForeman().addCommission(this);
            return true;
        }
        return false;
    }

    public static Commission getCommission(int commissionId) {
        if (!commissions.containsKey(commissionId)) {
            throw new IllegalArgumentException("There's no commission with id " + commissionId);
        }
        return commissions.get(commissionId);
    }

    public boolean areEmployeesFree() {
        for (Employee employee : brigade.getEmployees()) {
            for (Commission commission : currentCommissions) {
                if (commission.getBrigade().getEmployees().contains(employee)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void run() {
        if (this.brigade != null && !this.jobs.isEmpty() && areEmployeesFree()) {
            currentCommissions.add(this);
            this.dateOfStart = LocalDateTime.now();
            this.state = State.STARTED;
            for (Job job : this.jobs) {
                if (job.couldBeDone()) {
                    job.run();
                }
            }
            this.dateOfEnd = LocalDateTime.now();
            this.state = State.ENDED;
        }
    }

    public State getState() {
        return this.state;
    }

    public static void addCommission(Commission commission) {
        currentCommissions.add(commission);
    }

    public String toString() {
        return this.getClass().getName() + "( " + this.jobs + " " + this.getBrigade() + " " + this.getType() + " " +
                this.getDateOfCreation() + " " + this.getDateOfStart() + " " + this.getDateOfEnd() + " "
                + this.getState() + " )";
    }
}