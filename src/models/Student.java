package models;

public class Student {
    private int Id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double averageScore;

    public Student() {
    }

    public Student(int id, String name, int age, String gender, String address, double averageScore) {
        Id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.averageScore = averageScore;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", averageScore=" + averageScore +
                '}';
    }
    public String write (){
        return +getId() + "," + getName() + "," + getAge() + "," + getGender() + "," + getAddress() + "," + getAverageScore();
    }
}
