import java.util.HashMap;
import java.util.HashSet;

public class Job extends Thread {
    private static int counter = 0;
    private final int jobID;
    private final TypeOfJob typeOfJob;
    private final int timeOfWork;
    private boolean isDone = false;
    private final String description;
    private final HashSet<Job> jobsToBeDone = new HashSet<>();//nie mozna zmienic tego co dzieje sie pod danym adresem,
    // ale mozna zmieniac elementy, np. dodawac
    private static final HashMap<Integer, Job> jobMap = new HashMap<>();

    public Job(TypeOfJob typeOfJob, int timeOfWork, String description) {
        this.jobID = ++counter;
        this.typeOfJob = typeOfJob;
        this.timeOfWork = timeOfWork;
        this.description = description;
        jobMap.put(this.jobID, this);
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

    public static Job getJob(int jobID) {
        return jobMap.get(jobID);
    }

    public void addJobToBeDone(Job job) {
        this.jobsToBeDone.add(job);
    }

    public void addJobsToBeDone(HashSet<Job> jobsToBeDone) {
        this.jobsToBeDone.addAll(jobsToBeDone);
    }

    public boolean couldBeDone() {
        for (Job job : jobsToBeDone) {
            if (!job.isDone()) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        System.out.println("Job " + this.jobID + " started");
        try {
            Thread.sleep(this.timeOfWork * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Job " + this.jobID + " interrupted");
        }
        this.isDone = true;
        System.out.println("Job " + this.jobID + " finished");
    }

    public String toString() {
        return this.getClass().getName() + "( " + this.jobID + " " + this.typeOfJob + " " + this.timeOfWork + " "
                + this.getDescription() + jobsToBeDone + " )";
    }
}