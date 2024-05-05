import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.HashSet;

public class Main {
    public static ArrayList<String> occupiedNames = new ArrayList<>();

    public static HashMap<Integer, Job> jobs = new HashMap<>();
    public static HashMap<Integer, Commission> commissions = new HashMap<>();
    public static int amountJ = 0;
    public static int amountC = 0;
    public static int amountED = 0;
    public static int amountE = 0;
    public static int amountB = 0;

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("history.txt");
        EmployeeDepartment employeeDepartment = new EmployeeDepartment("Factory");
        EmployeeDepartment newEmployeeDepartment = employeeDepartment.createDepartment(employeeDepartment);
        writer.write(newEmployeeDepartment.toString() + "\n");
        Specialist specialist = new Specialist("Adam", "Smith",
                LocalDateTime.of(2012, 12, 12, 2, 15), employeeDepartment,
                "Engineer");
        writer.write(specialist + "\n");
        User user = new User("Alexander", "Bell",
                LocalDateTime.of(2021, 1, 14, 5, 45), employeeDepartment, "abc",
                "123");
        writer.write(user + "\n");
        String newInitial = user.modifyInitial("Alexander", "Dell");
        writer.write(newInitial + "\n");
        Foreman foreman = new Foreman("Ali", "Kill",
                LocalDateTime.of(2001, 4, 15, 6, 45), employeeDepartment, "123",
                "456");
        writer.write(foreman + "\n");
        HashMap<Brigade, Commission> map = foreman.getCommissions();
        writer.write(map.toString() + "\n");
        foreman.compareTo(user);
        foreman.compareTo(specialist);
        writer.write(Employee.employees + "\n");
        Brigade brigade = new Brigade("FirstOne", foreman);
        Foreman foreman2 = new Foreman("Alex", "Kill",
                LocalDateTime.of(2001, 4, 15, 6, 45), employeeDepartment, "abc",
                "qwerty");
        brigade.addEmployee(foreman2);
        brigade.addEmployee(Employee.employees);
        writer.write(brigade + "\n");
        Commission commission = new Commission(true);
        writer.write(commission + "\n");
        Commission commission2 = new Commission(true, brigade);
        writer.write(commission2 + "\n");
        HashSet<Job> hash = new HashSet<>();
        Job job = new Job(TypeOfJob.GENERAL, 123, "Some job");
        job.start();
        writer.write(job + "\n");
        Commission commission3 = new Commission(true, hash);
        writer.write(commission3 + "\n");
        Commission commission4 = new Commission(true, hash, brigade);
        writer.write(commission4 + "\n");
        commission2.addJob(new Job(TypeOfJob.DISASSEMBLY, 24, "The other job"));
        commission3.addJob(hash);
        commission.addJob(commission.jobs);
        commission2.addJob(commission2.jobs);
        commission3.addJob(commission3.jobs);
        commission4.addJob(commission4.jobs);
        Commission.addCommission(commission);
        Commission.addCommission(commission2);
        Commission.addCommission(commission3);
        Commission.addCommission(commission4);
        writer.write(commissions.toString() + "\n");
        writer.write(jobs.toString() + "\n");
        commission.addBrigade(brigade);
        commission2.addBrigade(brigade);
        commission3.addBrigade(brigade);
        commission4.addBrigade(brigade);
        commission.run();
        commission2.run();
        commission3.run();
        commission4.run();
        Job.addJob(job);
        boolean isDone = job.isDone();
        writer.write(isDone ? "1" : "0" + "\n");
        writer.close();

        FileReader fileReader = new FileReader("history.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        System.out.println(bufferedReader.lines());
        fileReader.close();
        bufferedReader.close();
    }
}