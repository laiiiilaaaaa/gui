import java.util.HashSet;

enum TypeOfJob {
    GENERAL,
    ASSEMBLY,
    DISASSEMBLY,
    EXCHANGE
}

public class Job extends Thread {
    private static int counter = 0;
    private final int jobID;
    private final TypeOfJob typeOfJob;
    private int timeOfWork;
    private boolean isDone = false;
    private final String description;
    private static HashSet<Job> jobs = new HashSet<>();

    public Job(TypeOfJob typeOfJob, int timeOfWork, String description) {
        this.jobID = ++counter;
        this.typeOfJob = typeOfJob;
        this.timeOfWork = timeOfWork;
        this.description = description;
    }

    public TypeOfJob getTypeOfJob() {
        return this.typeOfJob;
    }

    public int getTimeOfWork() {
        return this.timeOfWork;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public void run() {
        for (Job job : jobs) {
            job.start();
            job.isDone = true;
            job.timeOfWork = timeOfWork;
            System.out.println(this.getTypeOfJob() + " " + this.getTimeOfWork() + " " + this.getDescription());
            job.interrupt();
        }
        this.isDone = true;
    }

    public static void addJob(Job job) {
        jobs.add(job);
    }

    public String toString() {
        return this.getClass().getName() + "( " + this.getTypeOfJob() + " " + this.getTimeOfWork() + " "
                + this.getDescription() + jobs + " )";
    }
}