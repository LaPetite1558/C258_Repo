package com.sg.classobjects.scores;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class StudentQuizGrades {
    private final Map<String, ArrayList<Integer>> quizData;

    public StudentQuizGrades() {
        this.quizData = new HashMap<>(3);
    }

    public StudentQuizGrades(Map<String, ArrayList<Integer>> quizData) {
        this.quizData = quizData;
    }

    public double studentAvgScore(String student) {
        try {
            return BigDecimal.valueOf(getQuizData().get(student).stream()
                            .collect(Collectors
                                    .averagingDouble(Integer::doubleValue))).
                    setScale(2, RoundingMode.HALF_UP).doubleValue();
        } catch (NullPointerException e) {
            System.out.println("No such student.");
        }
        return Double.MIN_VALUE;
    }

    public String studentLowestScore() {
        return getQuizData().entrySet().stream()
                .min(Comparator.comparing(
                        student -> student.getValue()
                                .stream().min(Comparator
                                        .comparingInt(Integer::intValue))
                                .orElse(Integer.MAX_VALUE)))
                .orElseThrow(NullPointerException::new).getKey();
    }

    public String studentHighestScore() {
        return getQuizData().entrySet().stream()
                .max(Comparator.comparing(
                        student -> student.getValue()
                                .stream().max(Comparator
                                        .comparingInt(Integer::intValue))
                                .orElse(Integer.MIN_VALUE)))
                .orElseThrow(NullPointerException::new).getKey();
    }

    public double classAvgScore() {
        return BigDecimal.valueOf(getQuizData()
                        .values()
                        .stream()
                        .collect(Collectors.averagingDouble(
                                v -> v.stream().collect(Collectors
                                        .averagingDouble(Integer::intValue))))).
                setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public Map<String, ArrayList<Integer>> getQuizData() {
        return quizData;
    }
}

class TestStudentGrades {
    public static void main(String[] args) {
        StudentQuizGrades quizGrades = new StudentQuizGrades();
        Map<String, ArrayList<Integer>> quizData = quizGrades.getQuizData();
        quizData.put("Bob", new ArrayList<>(Arrays.asList(53,62,74)));
        quizData.put("Joe", new ArrayList<>(Arrays.asList(75,69,81)));
        quizData.put("Lee", new ArrayList<>(Arrays.asList(72,83,92)));

        System.out.println(quizGrades.classAvgScore());
        System.out.println(quizGrades.studentAvgScore("Jane"));

        System.out.println(quizGrades.studentHighestScore());
        System.out.println(quizGrades.studentLowestScore());

//        Map<String,ArrayList<Integer>> quizData = new HashMap<>();
//
//        quizData.put("Bob", new ArrayList<>(Arrays.asList(53,62,74)));
//        quizData.put("Joe", new ArrayList<>(Arrays.asList(75,69,81)));
//        quizData.put("Lee", new ArrayList<>(Arrays.asList(72,83,92)));
//
//        try {
//            System.out.println(avgScore(quizData, "Bob"));
//            System.out.println(avgScore(quizData, "Jane"));
//        } catch (Exception e) {
//            System.out.println("No student found.");
//        }
    }
}
