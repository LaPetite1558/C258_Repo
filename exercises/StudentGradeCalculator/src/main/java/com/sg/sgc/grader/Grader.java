package com.sg.sgc.grader;

import com.sg.sgc.dto.Student;
import javafx.util.Pair;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Grader {
    public static String getGrade(int marks) {
        String grade;
        if (marks > 90) {
           grade = "A";
        } else if (marks > 80) {
            grade = "B";
        } else if (marks > 70) {
            grade = "C";
        } else grade = "F";
        return grade;
    }

    public static Pair<Student, Map.Entry<String,Integer>> studentLowestScore(List<Student> studentList)
            throws NullPointerException {
        Student lowestStudent = studentList.stream().min(Comparator.comparing(student ->
                student.getSubjectMarks()
                        .values().stream()
                        .min(Comparator.comparingInt(Integer::intValue))
                        .orElseThrow(NullPointerException::new))).orElseThrow(NullPointerException::new);
        Map.Entry<String,Integer> lowestSubMarks = lowestStudent.getSubjectMarks().entrySet()
                .stream().min(java.util.Map.Entry.comparingByValue())
                .orElseThrow(NullPointerException::new);
        return new Pair<>(lowestStudent, lowestSubMarks);

    }

    public static Pair<Student, Map.Entry<String,Integer>> studentHighestScore(List<Student> studentList)
            throws NullPointerException {
        Student highestStudent = studentList.stream().max(Comparator.comparing(student ->
                student.getSubjectMarks()
                        .values().stream()
                        .max(Comparator.comparingInt(Integer::intValue))
                        .orElseThrow(NullPointerException::new))).orElseThrow(NullPointerException::new);
        Map.Entry<String,Integer> highestSubMarks = highestStudent.getSubjectMarks().entrySet()
                .stream().max(java.util.Map.Entry.comparingByValue())
                .orElseThrow(NullPointerException::new);
        return new Pair<>(highestStudent, highestSubMarks);

    }
}
