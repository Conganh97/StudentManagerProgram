package io;

import models.Student;

import java.io.*;
import java.util.ArrayList;

public class ReaderAndWriter {

    public void write (ArrayList <Student> students){
        File file = new File("C:\\Users\\ADMIN\\Desktop\\Code\\module2\\Crud\\StudentManagerProgram\\src\\Student.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student st : students) {
                bufferedWriter.write(st.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList <Student> read (){
        ArrayList <Student> students = new ArrayList<>();
        File file = new File("C:\\Users\\ADMIN\\Desktop\\Code\\module2\\Crud\\StudentManagerProgram\\src\\Student.csv");


        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null){
                String [] arr = str.split(",");
                int Id = Integer.parseInt(arr[0]);
                String name = arr[1];
                int age = Integer.parseInt(arr[2]);
                String gender = arr[3];
                String address = arr[4];
                double averageScore = Double.parseDouble(arr[5]);
                students.add(new Student(Id, name, age, gender, address, averageScore));
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

}
