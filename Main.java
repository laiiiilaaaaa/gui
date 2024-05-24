import java.time.LocalDateTime;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException, NotUniqueNameException {
        FileWriter writer = new FileWriter("history.txt");
        EmployeeDepartment employeeDepartment1 = EmployeeDepartment.createDepartment("Engineer Department");
        EmployeeDepartment employeeDepartment2 = EmployeeDepartment.createDepartment("Law Department");
        EmployeeDepartment employeeDepartment3 = EmployeeDepartment.createDepartment("Engineer Department");
        Specialist specialist1 = new Specialist("Adam", "Smith", LocalDateTime.of(2013, 4,
                14, 4, 15), employeeDepartment1, "Engineer");
        User user1 = new User("Alexander", "Bell", LocalDateTime.of(2020, 1, 14,
                5, 45), employeeDepartment1, "1234", "Abc%");
        ArrayList<Job> jobs = createJobs(employeeDepartment2, employeeDepartment3, employeeDepartment1);
        Job job1 = new Job(TypeOfJob.GENERAL, 500, "Best designer");
        jobs.add(job1);
        Job job2 = new Job(TypeOfJob.ASSEMBLY, 500, "Best manager");
        jobs.add(job2);
        Job job3 = new Job(TypeOfJob.DISASSEMBLY, 450, "Best engineer");
        jobs.add(job3);
        Job job4 = new Job(TypeOfJob.EXCHANGE, 350, "Best worker, all fields");
        jobs.add(job4);
        writer.close();
        FileReader fileReader = new FileReader("history.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        System.out.println(bufferedReader.lines());
        fileReader.close();
        bufferedReader.close();
    }

    private static ArrayList<Job> createJobs(EmployeeDepartment employeeDepartment2, EmployeeDepartment
            employeeDepartment3, EmployeeDepartment employeeDepartment1) {
        Foreman foreman1 = new Foreman("Alexander", "Graham", LocalDateTime.of(1998, 11,
                5, 5, 30), employeeDepartment2, "93875", "Qwerty*");
        Specialist specialist2 = new Specialist("Jake", "Smith", LocalDateTime.of(2015, 3,
                14, 4, 15), employeeDepartment2, "Lawyer");
        User user2 = new User("Kate", "Black", LocalDateTime.of(2005, 11, 14,
                5, 45), employeeDepartment3, "34665", "&Abc%");
        Foreman foreman2 = new Foreman("Adam", "Graham", LocalDateTime.of(1989, 5,
                5, 5, 5), employeeDepartment3, "9we38495", "Quad39ab");
        Specialist specialist3 = new Specialist("Alex", "White", LocalDateTime.of(2013, 4,
                14, 4, 15), employeeDepartment3, "Manager");
        User user3 = new User("Elise", "Bell", LocalDateTime.of(1980, 1, 4,
                4, 44), employeeDepartment3, "1234", "A%*bc%");
        ArrayList<Job> jobs = getJobs(employeeDepartment1, foreman1, foreman2);
        return jobs;
    }

    private static ArrayList<Job> getJobs(EmployeeDepartment employeeDepartment1, Foreman foreman1, Foreman foreman2) {
        Foreman foreman3 = new Foreman("Andy", "Graham", LocalDateTime.of(1998, 11,
                5, 5, 30), employeeDepartment1, "93875", "Qwerty*");
        Brigade brigade1 = new Brigade("Designers", foreman1);
        Brigade brigade2 = new Brigade("Managers", foreman2);
        Brigade brigade3 = new Brigade("Engineers", foreman3);
        ArrayList<Job> jobs = new ArrayList<>();
        Commission commission1 = new Commission(true);
        Commission commission2 = new Commission(false);
        Commission commission3 = new Commission(true, brigade1);
        Commission commission4 = new Commission(false, brigade2);
        Commission commission5 = new Commission(true, jobs);
        Commission commission6 = new Commission(true, jobs, brigade3);
        Commission commission7 = new Commission(false, jobs, brigade1);
        return jobs;
    }
}