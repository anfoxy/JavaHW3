package com.netcracker.ch1;

public class Student {
    private String studentName;
    private int quizScore;
    private int quizCount = 0;


    public Student(String name) {
        studentName = name;
        quizScore = 0;
    }


    public String getName() {
        return studentName;
    }


    public void addQuiz(int score) {

        quizScore = quizScore + score;
        quizCount++;
    }


    public int getTotalScore() {
        return quizScore;
    }


    public double getAverageScore() {
        return (quizScore * 1.0) / (quizCount * 1.0);
    }

    public int getQuizCount() {
        return quizCount;
    }
}
