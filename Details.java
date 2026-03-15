import java.util.*;
import java.io.*;

public class Details{

    static class Student {
        int id;
        String name;
        int age;

        Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return id + "," + name + "," + age;
        }
    }

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Save to File");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    saveToFile();
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        students.add(new Student(id, name, age));
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found");
            return;
        }

        for (Student s : students) {
            System.out.println("ID: " + s.id + " Name: " + s.name + " Age: " + s.age);
        }
    }

    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student Found: " + s.name);
                return;
            }
        }

        System.out.println("Student not found");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        students.removeIf(s -> s.id == id);
        System.out.println("Record deleted if ID existed.");
    }

    static void saveToFile() {
        try {
            FileWriter fw = new FileWriter("students.txt");

            for (Student s : students) {
                fw.write(s.toString() + "\n");
            }

            fw.close();
            System.out.println("Data saved to file");

        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}