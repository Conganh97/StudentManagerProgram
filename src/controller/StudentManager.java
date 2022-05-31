package controller;

import io.ReaderAndWriter;
import models.SortAscending;
import models.SortDecrease;
import models.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    ReaderAndWriter readerAndWriter = new ReaderAndWriter();

    public StudentManager() {
        students = readerAndWriter.read();
    }

    public void menu() {
        System.out.println("=====Menu=====");
        System.out.println("1.| Display student list");
        System.out.println("2.| Create student");
        System.out.println("3.| Edit student");
        System.out.println("4.| Delete student");
        System.out.println("5.| Sort student list");
        System.out.println("6.| Read on file");
        System.out.println("7.| Writen on file");
        System.out.println("8.| Exit!!!");
        System.out.println("Choose option: ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                displayStudentList();
                break;
            case 2:
                addStudent(createStudent());
                break;
            case 3:
                editStudentById(searchStudent());
                break;
            case 4:
                deleteStudentByID(searchStudent());
                break;
            case 5:
                choice5();
                break;
            case 6:
                readList();
                break;
            case 7:
                writeList();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("No option!!");
                break;
        }
    }

    public void displayStudentList() {
        for (Student st : students) {
            sc.nextLine();
            System.out.println(st);
        }
    }

    public Student createStudent() {
        while (true) {
            try {
                System.out.println("Enter id student: ");
                int ID = Integer.parseInt(sc.nextLine());
                System.out.println("Enter student's name: ");
                String name = sc.nextLine();
                System.out.println("Enter student's age: ");
                int age = Integer.parseInt(sc.nextLine());
                System.out.println("Enter gender: ");
                String gender = sc.nextLine();
                System.out.println("Enter address: ");
                String address = sc.nextLine();
                System.out.println("Enter average score: ");
                double averageScore = Double.parseDouble(sc.nextLine());
                return new Student(ID, name, age, gender, address, averageScore);
            } catch (Exception e) {
                System.out.println("Enter wrong!! Enter again");
            }
        }
    }
    public void addStudent(Student student) {
        students.add(student);
    }

    public int searchStudent() {
        while (true) {
            try {
                System.out.println("Enter student's id  you want search: ");
                String ID = sc.nextLine();
                if (ID.equals("") ){
                    menu();
                } else {
                    int id = Integer.parseInt(ID);
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getId() == id) return i;
                }
                return -1;
                }
            } catch (Exception e) {
                System.out.println("Enter wrong!! Enter id again!!");
            }
        }
    }

    public void editStudentById(int index) {
        while (true) {
            try {
                System.out.println("Student need to edit is: " + students.get(index));
                System.out.println("Enter student's name: ");
                String name = sc.nextLine();
                students.get(index).setName(name);
                System.out.println("Enter student's age: ");
                int age = Integer.parseInt(sc.nextLine());
                students.get(index).setAge(age);
                System.out.println("Enter gender: ");
                String gender = sc.nextLine();
                students.get(index).setGender(gender);
                System.out.println("Enter address: ");
                String address = sc.nextLine();
                students.get(index).setAddress(address);
                System.out.println("Enter average score: ");
                double averageScore = Double.parseDouble(sc.nextLine());
                students.get(index).setAverageScore(averageScore);
                System.out.println("Edit success");
            } catch (Exception e) {
                System.out.println("Enter wrong!! Enter again");
            }
        }

    }

    public void deleteStudentByID(int index) {
        System.out.println("Are you sure delete student ? " + students.get(index) + " Yes press 'Y' - No press enter " );
        String str = sc.nextLine();
        if (str.equals("y")){
            students.remove(index);
            System.out.println("Delete success");
        } else menu();

    }
    public void choice5 (){
        int choice = -1;
            while (choice != 3){
            System.out.println("=====Sort student by average score===== ");
             System.out.println("1.| Sort by ascending ");
            System.out.println("2.| Sort by decrease")  ;
            System.out.println("3.| Exit");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    students.sort(new SortAscending());
                    break;
                case 2:
                    students.sort(new SortDecrease());
                    break;
                case 3:
                    System.out.println("Exit sort option!!");
                    break;
                default:
                    System.out.println("No option!!");
                    break;
             }
        }
    }
    public void readList (){
        System.out.println("Are you sure read list ? (Delete all list's information before this. Yes press 'Y' - No press enter ");
        String str = sc.nextLine();
        if (str.equals("y")){
            readerAndWriter.read();
        } else menu();
    }

    public void writeList (){
        System.out.println("Are you sure save file ? (Delete all file's information before this. Yes press 'Y' - No press enter ");
        String str = sc.nextLine();
        if (str.equals("y")){
            readerAndWriter.write(students);
        } else menu();
    }
}
