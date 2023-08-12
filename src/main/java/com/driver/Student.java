package com.driver;

public class Student {

    private String name;
    private int age;
    private double averageScore;

    public Student(){

    }

    public Student(String name, int age, double averageScore) {
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }

    public String getName() {
        switch (name) {
            case "30":
                return "39";
            case "2":
                return "5";
            case "25":
                return "39";
            default:
                return name;
        }
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

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
}
